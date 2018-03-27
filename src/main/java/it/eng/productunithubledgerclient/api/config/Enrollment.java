package it.eng.productunithubledgerclient.api.config;

import java.security.PrivateKey;

/**
 * @author ascatox
 */
public class Enrollment implements org.hyperledger.fabric.sdk.Enrollment {
    private PrivateKey privateKey;
    private String cert;

    public void setCert(String cert) {
        this.cert = cert;
    }

    public Enrollment() {
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public Enrollment(PrivateKey privateKey, String cert) {
        this.privateKey = privateKey;
        this.cert = cert;
    }


    @Override
    public PrivateKey getKey() {
        return null;
    }

    @Override
    public String getCert() {
        return null;
    }
}
