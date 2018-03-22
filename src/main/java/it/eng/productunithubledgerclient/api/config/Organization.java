package it.eng.productunithubledgerclient.api.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.hyperledger.fabric.sdk.User;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    private String mspID;
    private List<PeerConfig> peerConfigs;
    private List<OrdererConfig> ordererConfigs;
    private List<User> users;

    private Ca ca;

    public Organization(String mspID, List<PeerConfig> peerConfigs, List<OrdererConfig> ordererConfigs, Object ca) {
        this.mspID = mspID;
        this.peerConfigs = new ArrayList<>();
        this.ordererConfigs = new ArrayList<>();
        this.ca = new Ca();
        this.users = new ArrayList<>();
    }

    public Organization() {
        this.peerConfigs = new ArrayList<>();
        this.ordererConfigs = new ArrayList<>();
        this.ca = new Ca();
    }

    public String getMspID() {
        return mspID;
    }

    public void setMspID(String mspID) {
        this.mspID = mspID;
    }

    public List<PeerConfig> getPeerConfigs() {
        return peerConfigs;
    }

    public void setPeerConfigs(List<PeerConfig> peerConfigs) {
        this.peerConfigs = peerConfigs;
    }

    public List<OrdererConfig> getOrdererConfigs() {
        return ordererConfigs;
    }

    public void setOrdererConfigs(List<OrdererConfig> ordererConfigs) {
        this.ordererConfigs = ordererConfigs;
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


}

