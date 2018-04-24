package it.eng.productunithubledgerclient.fabric.integration;


import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProxyConfig {

    public static void setProxy()

    {
        try {
            HashMap<String, String> env = new HashMap<>();
            env.put("http_proxy","http://192.168.62.200:8680");
            env.put("https_proxy", "http://192.168.62.200:8680");
            env.put("GRPC_PROXY_EXP", "192.168.62.200:8680");
            setEnv(env);

            //SET HTTPS
            System.setProperty("https.proxyHost", "http://localhost");
            System.setProperty("https.proxyPort", "8680");
            System.setProperty("https.proxyUser", "ascatolo");
            System.setProperty("https.proxyPassword", "Fs26112011");

        } catch (Exception e) {
            System.err.println(e);
        }
    }


    protected static void setEnv(Map<String, String> newenv) throws Exception {
        try {
            Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
            Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
            theEnvironmentField.setAccessible(true);
            Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
            env.putAll(newenv);
            Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
            theCaseInsensitiveEnvironmentField.setAccessible(true);
            Map<String, String> cienv = (Map<String, String>)     theCaseInsensitiveEnvironmentField.get(null);
            cienv.putAll(newenv);
        } catch (NoSuchFieldException e) {
            Class[] classes = Collections.class.getDeclaredClasses();
            Map<String, String> env = System.getenv();
            for(Class cl : classes) {
                if("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
                    Field field = cl.getDeclaredField("m");
                    field.setAccessible(true);
                    Object obj = field.get(env);
                    Map<String, String> map = (Map<String, String>) obj;
                    map.clear();
                    map.putAll(newenv);
                }
            }
        }
    }


}
