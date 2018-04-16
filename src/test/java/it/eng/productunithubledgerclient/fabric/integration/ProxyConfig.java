package it.eng.productunithubledgerclient.fabric.integration;


public class ProxyConfig {

    public void Proxy()

    {
        try {
            //SET HTTP
            System.setProperty( "http.proxyHost", "http://proxy.acme.me" );
            System.setProperty( "http.proxyPort", "666" );
            System.setProperty( "http.nonProxyHosts", "localhost|127.0.0.1" );

            //SET HTTPS
            System.setProperty( "https.proxyHost", "http://proxy.acme.me" );
            System.setProperty( "https.proxyPort", "666" );
            System.setProperty( "https.proxyUser", "" );
            System.setProperty( "https.proxyPassword", "" );

        } catch (Exception e) {
            System.err.println( e );
        }
    }
}
