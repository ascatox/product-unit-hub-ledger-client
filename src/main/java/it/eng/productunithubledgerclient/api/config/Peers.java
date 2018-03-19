package it.eng.productunithubledgerclient.api.config;

import java.util.Objects;

public class Peers {

    private String requestURL;
    private String eventURL;


    public Peers(String requestURL, String eventURL) {
        this.requestURL = requestURL;
        this.eventURL = eventURL;
    }

    public Peers() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Peers)) return false;
        Peers peers = (Peers) o;
        return Objects.equals( requestURL, peers.requestURL ) && Objects.equals( eventURL, peers.eventURL );
    }

    @Override
    public int hashCode() {

        return Objects.hash( requestURL, eventURL );
    }
}
