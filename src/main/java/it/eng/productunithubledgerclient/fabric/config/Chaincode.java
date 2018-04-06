package it.eng.productunithubledgerclient.fabric.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hyperledger.fabric.sdk.ChaincodeID;

/**
 * @author ascatox
 */
public class Chaincode {


    /*
    private String CHAIN_CODE_FILEPATH = "sdkintegration/gocc/sample_11";
    String CHAIN_CODE_NAME = "example_cc_go";
    String CHAIN_CODE_PATH = "github.com/example_cc";
    String CHAIN_CODE_VERSION_11 = "11";
    String CHAIN_CODE_VERSION = "1";
    */

    private String path;
    private String name;
    private String version;
    private String lang;

    public Chaincode() {
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @JsonProperty
    public ChaincodeID getChaincodeID(){
        ChaincodeID chaincodeID = ChaincodeID.newBuilder().setName(getName())
                .setVersion(getVersion())
                .setPath(getPath()).build();
        return chaincodeID;
    }


}
