package it.eng.productunithubledgerclient.api.config;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null)
            return false;
        return mspId != null ? mspId.equals(user.mspId) : user.mspId == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (mspId != null ? mspId.hashCode() : 0);
        return result;
    }
}
