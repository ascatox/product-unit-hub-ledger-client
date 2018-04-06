package it.eng.productunithubledgerclient.fabric.config;

import java.util.Objects;

public class OrdererConfig {

    private String name;
    private String url;


    public OrdererConfig(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public OrdererConfig() {
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
        if (!(o instanceof OrdererConfig)) return false;
        OrdererConfig orderers = (OrdererConfig) o;
        return Objects.equals( url, orderers.url );
    }

    @Override
    public int hashCode() {

        return Objects.hash( url );
    }
}
