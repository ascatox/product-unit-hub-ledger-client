package it.eng.productunithubledgerclient.api.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import org.hyperledger.fabric.sdk.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {

    private String mspID;

    private List<Peer> peers;
    private List<Orderer> orderers;
    private List<User> users;

    private Ca ca;

    public Organization(String mspID, List<Peer> peers, List<Orderer> orderers, Object ca) {
        this.mspID = mspID;
        this.peers = new ArrayList<>();
        this.orderers = new ArrayList<>();
        this.ca = new Ca();
        this.users = new ArrayList<>();
    }

    public Organization() {
        this.peers = new ArrayList<>();
        this.orderers = new ArrayList<>();
        this.ca = new Ca();
    }

    public String getMspID() {
        return mspID;
    }

    public void setMspID(String mspID) {
        this.mspID = mspID;
    }

    public List<Peer> getPeers() {
        return peers;
    }

    public void setPeers(List<Peer> peers) {
        this.peers = peers;
    }

    public List<Orderer> getOrderers() {
        return orderers;
    }

    public void setOrderers(List<Orderer> orderers) {
        this.orderers = orderers;
    }

    public Object getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }

    public List<User> getUsers() {
        return users;
    }

    @JsonIgnore
    public void setUsers(List<User> users) {
        this.users = users;
    }

    //@See Claudio
    //FIXME Add a json file to store users!!!!
    public User getAdminUser() {
        if (getUsers().isEmpty())
            return null;
        for (User user :
                users) {
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

    public User loadUser(String userName) {
        if (StringUtils.isEmpty(userName))
            return null;
        for (User user :
                users) {
            if (user.getName().equals(userName))
                return user;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Organization))
            return false;
        Organization that = (Organization) o;
        return Objects.equals(mspID, that.mspID) && Objects.equals(peers, that.peers) && Objects.equals(orderers, that.orderers) && Objects.equals(ca, that.ca);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mspID, peers, orderers, ca);
    }
}

