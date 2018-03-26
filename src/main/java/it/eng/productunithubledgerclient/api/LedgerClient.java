package it.eng.productunithubledgerclient.api;

import it.eng.productunithubledgerclient.api.config.Chaincode;
import it.eng.productunithubledgerclient.api.config.ConfigManager;
import it.eng.productunithubledgerclient.api.config.Configuration;
import it.eng.productunithubledgerclient.api.config.Organization;
import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.api.helper.ChannelInitializationManager;
import it.eng.productunithubledgerclient.api.helper.LedgerInteractionHelper;
import it.eng.productunithubledgerclient.model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.helper.Config;
import org.hyperledger.fabric.sdk.helper.Utils;

import javax.rmi.CORBA.Util;
import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;


final public class LedgerClient implements it.eng.productunithubledgerclient.api.base.LedgerClient {

    private final static Logger log = LogManager.getLogger(LedgerClient.class);
    private LedgerInteractionHelper ledgerInteractionHelper;
    private ChannelInitializationManager channelInitializationManager;
    private HFClient hfClient;
    private Configuration configuration;
    private ConfigManager configManager;
    private Channel channel;
    private static List<Organization> orgs;


   /* public void doLedgerClient() throws ProductUnitHubException {
        try{
            orgs = new ArrayList<>(  );
            ledgerInteractionHelper = new LedgerInteractionHelper("","", "");
            for (Organization org : orgs) {
                ledgerInteractionHelper.setup();
                channel = channelInitializationManager.();

            }
        } catch (Exception e) {
            throw new ProductUnitHubException( e );
        }
    }
    public void installChaincode(Chaincode chaincode) throws  ProductUnitHubException{
        try {
            ledgerInteractionHelper.controlIntalledChaincodeOnPeers( chaincode );
            log.debug( "Chaincode installed correctly" );

            ledgerInteractionHelper.controlInstantiatedChaincode( chaincode );
            log.debug( "Chaincode instantiated correctly" );
        }catch (Exception e){
            throw new ProductUnitHubException( e );
        }


    }*/

    public void storeProcessStepRouting(List<ChassisDTO> chassisDTOS) {
        //TODO
    }

    public void storeProcessStepResult(ChassisDTO chassisDTO) {
        //TODO
    }

    public List<ChassisDTO> getProcessStepRouting(String component, String subComponent) {
       //TODO
        return null;
    }
    public ChassisDTO getProcessStepResult(String chassisID, String component, String subComponent) {
        //TODO
        return null;
    }
}
