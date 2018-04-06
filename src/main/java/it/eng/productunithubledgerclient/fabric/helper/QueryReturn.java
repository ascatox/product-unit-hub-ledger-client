package it.eng.productunithubledgerclient.fabric.helper;

/**
 * @author ascatox
 */
public class QueryReturn {

    private String peerName;
    private String payload;

    public String getPeerName() {
        return peerName;
    }

    public void setPeerName(String peerName) {
        this.peerName = peerName;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public QueryReturn(String peerName, String payload) {
        this.peerName = peerName;
        this.payload = payload;
    }
}
