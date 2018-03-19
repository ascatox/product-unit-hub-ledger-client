package it.eng.productunithubledgerclient.api.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {

    private String mspID;

    private List<Peers> peers;
    private List<Orderers> orderers;

    private Ca ca;

    public Organization(String mspID, List<Peers> peers, List<Orderers> orderers, Object ca) {
        this.mspID = mspID;
        this.peers = new ArrayList<>(  );
        this.orderers = new ArrayList<>(  );
        this.ca = new Ca();
    }

    public Organization() {
        this.peers = new ArrayList<>(  );
        this.orderers = new ArrayList<>(  );
        this.ca = new Ca();
    }

    public String getMspID() {
        return mspID;
    }

    public void setMspID(String mspID) {
        this.mspID = mspID;
    }

    public List<Peers> getPeers() {
        return peers;
    }

    public void setPeers(List<Peers> peers) {
        this.peers = peers;
    }

    public List<Orderers> getOrderers() {
        return orderers;
    }

    public void setOrderers(List<Orderers> orderers) {
        this.orderers = orderers;
    }

    public Object getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        Organization that = (Organization) o;
        return Objects.equals( mspID, that.mspID ) && Objects.equals( peers, that.peers ) && Objects.equals( orderers, that.orderers ) && Objects.equals( ca, that.ca );
    }

    @Override
    public int hashCode() {

        return Objects.hash( mspID, peers, orderers, ca );
    }
}

