package it.eng.productunithubledgerclient.api.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Organization {

    private String mspID;
    private String domainName;
    private List<PeerConfig> peers;
    private List<OrdererConfig> orderers;
    private Set<User> users;
    private Ca ca;

    public Organization(String mspID, List<PeerConfig> peerConfigs, List<OrdererConfig> ordererConfigs, Ca ca) {
        this.mspID = mspID;
        this.peers = peerConfigs;
        this.orderers = ordererConfigs;
        this.ca = ca;
        this.users = new HashSet<>(); //HERE
    }

    public Organization() {
        this.peers = new ArrayList<>();
        this.orderers = new ArrayList<>(); //HERE
        this.ca = new Ca();
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getMspID() {
        return mspID;
    }

    public void setMspID(String mspID) {
        this.mspID = mspID;
    }

    public List<PeerConfig> getPeers() {
        return peers;
    }

    public void setPeers(List<PeerConfig> peers) {
        this.peers = peers;
    }

    public List<OrdererConfig> getOrderers() {
        return orderers;
    }

    public void setOrderers(List<OrdererConfig> orderers) {
        this.orderers = orderers;
    }

    public Object getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }

    public Set<User> getUsers() {
        return users;
    }

    @JsonIgnore
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    //@See Claudio
    //FIXME Add a json file to store users!!!
    //@See ascatox
    //TODO Control if it's correct!!!!
    public User getAdminUser() throws IOException {
        if (getUsers().isEmpty())
            return null;

       // ObjectMapper mapper = new ObjectMapper();
        for (User user : users) {
            // mapper.writeValue(new File("product-unit-hub-ledger-client/src/main/resources/json-user"), user );
            for (String role : user.getRoles()) {
                if (role.toLowerCase().contains("admin"))
                    return user;
            }
        }
        return null;
    }

    public User getPeerAdminUser() {
        if (getUsers().isEmpty())
            return null;
        for (User user :
                users) {
            for (String role : user.getRoles()) {
                if (role.toLowerCase().contains("peer"))
                    return user;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Organization that = (Organization) o;

        return mspID != null ? mspID.equals(that.mspID) : that.mspID == null;
    }

    @Override
    public int hashCode() {
        return mspID != null ? mspID.hashCode() : 0;
    }



}

