package it.eng.productunithubledgerclient.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

import static io.netty.util.NetUtil.LOCALHOST;

public class ConfigManager {

    public static final String INVOKEWAITTIME = "100000";
    public static final String DEPLOYWAITTIME = "120000";
    public static final String PROPOSALWAITTIME = "120000";
    public static final String UTF_8 = "UTF-8";

    private final static Logger log = LogManager.getLogger(ConfigManager.class);

    private Configuration configuration;

    public ConfigManager() {
        this.configuration = getConfiguration();
    }

    public Configuration getConfiguration() {
        return loadConfigurationFromJSONFile();
    }

    private Configuration loadConfigurationFromJSONFile() {

        try {
            URL resource = getClass().getResource("config-network.json");
            File file = new File(resource.getFile());
            ObjectMapper objectMapper = new ObjectMapper();
            Configuration configuration = objectMapper.readValue(file, Configuration.class);

            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

            StringWriter stringEmp = new StringWriter();
            objectMapper.writeValue(stringEmp, configuration);
            log.debug("Configuration JSON is\n" + stringEmp);
            return configuration;
        } catch (Exception e) {
            log.error(e);
        }
        return null;

    }

    public Properties getPeerProperties(String name) {

        return getEndPointProperties("peer", name);

    }

    public Properties getOrdererProperties(String name) {

        return getEndPointProperties("orderer", name);

    }

    private Properties getEndPointProperties(final String type, final String name) {

        final String domainName = getDomainName(name);

        File cert = Paths.get(getTestChannelPath(), "crypto-config/ordererOrganizations".replace("orderer", type), domainName, type + "s",
                name, "tls/server.crt").toFile();
        if (!cert.exists()) {
            throw new RuntimeException(String.format("Missing cert file for: %s. Could not find at location: %s", name,
                    cert.getAbsolutePath()));
        }

        Properties ret = new Properties();
        ret.setProperty("pemFile", cert.getAbsolutePath());
        //      ret.setProperty("trustServerCertificate", "true"); //testing environment only NOT FOR PRODUCTION!
        ret.setProperty("hostnameOverride", name);
        ret.setProperty("sslProvider", "openSSL");
        ret.setProperty("negotiationType", "TLS");

        return ret;
    }

    public Properties getEventHubProperties(String name) {

        return getEndPointProperties("peer", name); //uses same as named peer

    }


    public String getFabricConfigTxLaterLocation() {
        return "http://" + LOCALHOST + ":7059";
    }


    private String getDomainName(final String name) {
        int dot = name.indexOf(".");
        if (-1 == dot) {
            return null;
        } else {
            return name.substring(dot + 1);
        }

    }

    public String getTestChannelPath() {
        return configuration.getCryptoconfigdir();
    }


    public int getTransactionWaitTime() {
        return Integer.parseInt(INVOKEWAITTIME);
    }

    public int getDeployWaitTime() {
        return Integer.parseInt(DEPLOYWAITTIME);
    }

    public long getProposalWaitTime() {
        return Integer.parseInt(PROPOSALWAITTIME);
    }





}//end class