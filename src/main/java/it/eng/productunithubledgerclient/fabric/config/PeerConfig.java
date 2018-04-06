package it.eng.productunithubledgerclient.fabric.config;

import java.util.Objects;

public class PeerConfig {

    private String name;
    private String requestURL;
    private String eventURL;


    public PeerConfig(String requestURL, String eventURL) {
        this.requestURL = requestURL;
        this.eventURL = eventURL;
    }

    public PeerConfig() {
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getEventURL() {
        return eventURL;
    }

    public void setEventURL(String eventURL) {
        this.eventURL = eventURL;
    }

    public PeerConfig(String name, String requestURL, String eventURL) {
        this.name = name;
        this.requestURL = requestURL;
        this.eventURL = eventURL;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PeerConfig)) return false;
        PeerConfig peers = (PeerConfig) o;
        return Objects.equals( requestURL, peers.requestURL ) && Objects.equals( eventURL, peers.eventURL );
    }

    @Override
    public int hashCode() {

        return Objects.hash( requestURL, eventURL );
    }
}
