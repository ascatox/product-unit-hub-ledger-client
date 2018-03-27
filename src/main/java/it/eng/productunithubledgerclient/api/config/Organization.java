package it.eng.productunithubledgerclient.api.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

public class Organization {

    private String mspID;
    private String domainName;
    private List<PeerConfig> peers;
    private List<OrdererConfig> orderers;
    private List<User> users;
    private Ca ca;

    private final static Logger log = LogManager.getLogger(Organization.class);


    public Organization(String mspID, List<PeerConfig> peerConfigs, List<OrdererConfig> ordererConfigs, Ca ca) {
        this.mspID = mspID;
        this.peers = peerConfigs;
        this.orderers = ordererConfigs;
        this.ca = ca;
        this.users = new ArrayList<>();
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


    /**
     * Get the user with a given name
     *
     * @param name
     * @param org
     * @param mspId
     * @param privateKeyFile
     * @param certificateFile
     * @return user
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeySpecException
     */
    /*public User getMember(String name, String org, String mspId, File privateKeyFile,
                          File certificateFile) throws ProductUnitHubException {
        try {
            // Try to get the User state from the cache
            User user = users.contains()
            if (null != user) {
                return user;
            }

            // Create the User and try to restore it's state from the key value store (if found).
            user = new User();
            user.setMspId(mspId);

            String certificate = new String(IOUtils.toByteArray(new FileInputStream(certificateFile)), ConfigManager.UTF_8);

            PrivateKey privateKey = getPrivateKeyFromBytes(IOUtils.toByteArray(new FileInputStream(privateKeyFile)));

            user.setEnrollment(new SampleStoreEnrollement(privateKey, certificate));

            return user;
        } catch (IOException | NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException | ClassCastException e) {
            log.error(e);
            throw new ProductUnitHubException(e);

        }
    }*/


}

