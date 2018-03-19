package it.eng.productunithubledgerclient.api.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Configuration {

    private String name;
    private String type;
    private String channel;
    private Integer timeout;
    private String cryptoconfigdir;

    private List<Organization> organizations;

    public Configuration(String name, String type, String mspID, String channel, Integer timeout, String cryptoconfigdir, List<Organization> organizations) {
        this.name = name;
        this.type = type;
        this.channel = channel;
        this.timeout = timeout;
        this.cryptoconfigdir = cryptoconfigdir;
        this.organizations = new ArrayList<>(  );
    }

    public Configuration() {
        this.organizations = new ArrayList<>(  );

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getCryptoconfigdir() {
        return cryptoconfigdir;
    }

    public void setCryptoconfigdir(String cryptoconfigdir) {
        this.cryptoconfigdir = cryptoconfigdir;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Configuration)) return false;
        Configuration that = (Configuration) o;
        return Objects.equals( name, that.name ) && Objects.equals( type, that.type ) && Objects.equals( channel, that.channel ) && Objects.equals( timeout, that.timeout ) && Objects.equals( cryptoconfigdir, that.cryptoconfigdir ) && Objects.equals( organizations, that.organizations );
    }

    @Override
    public int hashCode() {

        return Objects.hash( name, type, channel, timeout, cryptoconfigdir, organizations );
    }


    @Override
    public String toString() {
        return "Configuration{" + "name='" + name + '\'' + ", type='" + type + '\'' + ", channel='" + channel + '\'' + ", timeout=" + timeout + ", cryptoconfigdir='" + cryptoconfigdir + '\'' + ", organizations=" + organizations + '}';
    }
}