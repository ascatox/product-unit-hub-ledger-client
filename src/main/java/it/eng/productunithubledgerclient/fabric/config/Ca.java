package it.eng.productunithubledgerclient.fabric.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hyperledger.fabric_ca.sdk.HFCAClient;

import java.net.MalformedURLException;
import java.util.Objects;

public class Ca {

    private String url;
    private String name;

    private HFCAClient caClient;


    public Ca(String url, String name) throws MalformedURLException {
        this.url = url;
        this.name = name;
        this.caClient = HFCAClient.createNewInstance(url, null);
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

    @JsonProperty
    public HFCAClient getCaClient() {
        return caClient;
    }

    @JsonIgnore
    public void setCaClient(HFCAClient caClient) {
        this.caClient = caClient;
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
