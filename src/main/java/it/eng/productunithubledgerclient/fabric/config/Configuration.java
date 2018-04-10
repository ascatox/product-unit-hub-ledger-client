package it.eng.productunithubledgerclient.fabric.config;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Configuration {

    private String name;
    private String type;
    private String channelName;
    private Integer timeout;
    private String cryptoconfigdir;
    private boolean tls;

    private List<Organization> organizations;
    private Chaincode chaincode;

    public Configuration(String name, String type, String mspID, String channelName, Integer timeout, String cryptoconfigdir, List<Organization> organizations) {
        this.name = name;
        this.type = type;
        this.channelName = channelName;
        this.timeout = timeout;
        this.cryptoconfigdir = cryptoconfigdir;
        this.organizations = new ArrayList<>();
    }

    public Configuration() {
        this.organizations = new ArrayList<>();
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


    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getCryptoconfigdir() {
        if (StringUtils.isEmpty(cryptoconfigdir))
            this.setCryptoconfigdir(System.getProperty("user.home") + "/crypto-config");
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

    public Chaincode getChaincode() {
        return chaincode;
    }

    public void setChaincode(Chaincode chaincode) {

        this.chaincode = chaincode;
    }

    public boolean isTls() {
        return tls;
    }

    public void setTls(boolean tls) {
        this.tls = tls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Configuration))
            return false;
        Configuration that = (Configuration) o;
        return Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(channelName, that.channelName) && Objects.equals(timeout, that.timeout) && Objects.equals(cryptoconfigdir, that.cryptoconfigdir) && Objects.equals(organizations, that.organizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, channelName, timeout, cryptoconfigdir, organizations);
    }


    @Override
    public String toString() {
        return "Configuration{" + "name='" + name + '\'' + ", type='" + type + '\'' + ", channelName='" + channelName + '\'' + ", timeout=" + timeout + ", cryptoconfigdir='" + cryptoconfigdir + '\'' + ", organizations=" + organizations + '}';
    }
}