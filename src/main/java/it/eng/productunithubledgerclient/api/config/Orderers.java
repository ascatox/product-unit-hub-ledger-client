package it.eng.productunithubledgerclient.api.config;

import java.util.Objects;

public class Orderers {

    private String url;

    public Orderers(String url) {
        this.url = url;
    }

    public Orderers() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orderers)) return false;
        Orderers orderers = (Orderers) o;
        return Objects.equals( url, orderers.url );
    }

    @Override
    public int hashCode() {

        return Objects.hash( url );
    }
}
