package it.eng.productunithubledgerclient.fabric.config;

import java.security.PrivateKey;

/**
 * @author ascatox
 */
public class Enrollment implements org.hyperledger.fabric.sdk.Enrollment {
    private PrivateKey privateKey;
    private String cert;

    public Enrollment() {
    }

    public Enrollment(PrivateKey privateKey, String cert) {
        this.privateKey = privateKey;
        this.cert = cert;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public PrivateKey getKey() {
        return privateKey;
    }

    @Override
    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }
}

