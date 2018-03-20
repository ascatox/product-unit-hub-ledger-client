package it.eng.productunithubledgerclient.api.config;

import java.util.Objects;

public class Orderer {

    private String name;
    private String url;


    public Orderer(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Orderer() {
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orderer)) return false;
        Orderer orderers = (Orderer) o;
        return Objects.equals( url, orderers.url );
    }

    @Override
    public int hashCode() {

        return Objects.hash( url );
    }
}
