package it.eng.productunithubledgerclient.api.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hyperledger.fabric.sdk.Enrollment;

import java.util.Set;

/**
 * @author ascatox
 */
public class User implements org.hyperledger.fabric.sdk.User{
    private String name;
    private Set<String> roles;
    private String account;
    private String affiliation;
    private Enrollment enrollment;
    private String mspId;

    public User() {
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Set<String> getRoles() {
        return null;
    }

    @Override
    public String getAccount() {
        return null;
    }

    @Override
    public String getAffiliation() {
        return null;
    }

    @Override
    public Enrollment getEnrollment() {
        return null;
    }

    @Override
    public String getMspId() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JsonIgnore
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }


    @JsonIgnore
    public void setAccount(String account) {
        this.account = account;
    }


    @JsonIgnore
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }


    @JsonIgnore
    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }


    @JsonIgnore
    public void setMspId(String mspId) {
        this.mspId = mspId;
    }
}
