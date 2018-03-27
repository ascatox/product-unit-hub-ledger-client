package it.eng.productunithubledgerclient.api.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.hyperledger.fabric.sdk.User;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    private String mspID;
    private String domainName;
    private List<PeerConfig> peers;
    private List<OrdererConfig> orderers;
    private List<User> userList;
    private List<String> users;
    private Ca ca;

    public Organization(String mspID, List<PeerConfig> peerConfigs, List<OrdererConfig> ordererConfigs, Ca ca) {
        this.mspID = mspID;
        this.peers = peerConfigs;
        this.orderers = ordererConfigs;
        this.ca = ca;
        this.userList = new ArrayList<>();
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public Organization() {
        this.peers = new ArrayList<>();

        this.orderers = new ArrayList<>();
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

    public List<User> getUserList() {
        return userList;
    }

    @JsonIgnore
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    //@See Claudio
    //FIXME Add a json file to store userList!!!!
    public User getAdminUser() {
        if (getUserList().isEmpty())
            return null;
        for (User user :
                userList) {
            for (String role : user.getRoles()) {
                if (role.toLowerCase().contains("admin"))
                    return user;
            }
        }
        return null;
    }

    public User getPeerAdminUser() {
        if (getUserList().isEmpty())
            return null;
        for (User user :
                userList) {
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
                userList) {
            if (user.getName().equals(userName))
                return user;
        }
        return null;
    }


}

