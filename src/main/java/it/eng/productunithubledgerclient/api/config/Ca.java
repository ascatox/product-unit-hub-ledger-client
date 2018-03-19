package it.eng.productunithubledgerclient.api.config;

import java.util.Objects;

public class Ca {

    private String url;
    private String name;

    public Ca(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Ca() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(o instanceof Ca)) return false;
        Ca ca = (Ca) o;
        return Objects.equals( url, ca.url ) && Objects.equals( name, ca.name );
    }

    @Override
    public int hashCode() {

        return Objects.hash( url, name );
    }
}
