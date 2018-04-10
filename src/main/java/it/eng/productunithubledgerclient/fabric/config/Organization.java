package it.eng.productunithubledgerclient.fabric.config;

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
    private User peerAdminUser;
    private User adminUser;
    private User user;
    private User loggedUser;

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

    public Ca getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User getPeerAdminUser() {
        if (peerAdminUser == null) {
            peerAdminUser = doGetPeerAdminUser();
            if (peerAdminUser == null)
                peerAdminUser = getAdminUser();
        }

        return peerAdminUser;
    }

    public void setPeerAdminUser(User peerAdminUser) {
        this.peerAdminUser = peerAdminUser;
    }

    public User getAdminUser() {
        if (adminUser == null)
            adminUser = doGetAdminUser();
        return adminUser;
    }

    public void setAdminUser(User adminUser) {
        this.adminUser = adminUser;
    }

    public User getUser() {
        if (user == null)
            user = doGetUser();
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User doGetAdminUser() {
        if (null == getUsers() || getUsers().isEmpty())
            return null;
        for (User user : getUsers()) {
            for (String role : user.getRoles()) {
                if (role.toLowerCase().equals("admin"))
                    return user;
            }

        }
        return null;
    }

    private User doGetPeerAdminUser() {
        if (null == getUsers() || getUsers().isEmpty())
            return null;
        for (User user :
                getUsers()) {
            for (String role : user.getRoles()) {
                if (role.toLowerCase().equals("peer"))
                    return user;
            }
        }
        return null;
    }

    private User doGetUser() {
        if (null == getUsers() || getUsers().isEmpty())
            return null;
        for (User user :
                getUsers()) {
            for (String role : user.getRoles()) {
                if (!role.toLowerCase().equals("peer")
                        && !role.toLowerCase().equals("admin"))
                    return user;
            }
        }
        return null;
    }


    public User getLoggedUser() {
        if (getAdminUser() != null)
            loggedUser = getAdminUser();
        else if (getPeerAdminUser() != null)
            loggedUser = getPeerAdminUser();
        else
            loggedUser = getUser();
        return loggedUser;
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

