package it.eng.productunithubledgerclient.fabric.integration;


public class ProxyConfig {

    public void Proxy()

    {
        try {
            //SET HTTP
            System.setProperty( "http.proxyHost", "http://proxy.eng.it" );
            System.setProperty( "http.proxyPort", "3128" );
            System.setProperty( "http.nonProxyHosts", "localhost|127.0.0.1" );

            //SET HTTPS
            System.setProperty( "https.proxyHost", "http://proxy.eng.it" );
            System.setProperty( "https.proxyPort", "3128" );
            System.setProperty( "https.proxyUser", "cbarberini" );
            System.setProperty( "https.proxyPassword", "Barrettm82" );

        } catch (Exception e) {
            System.err.println( e );
        }
    }
}
