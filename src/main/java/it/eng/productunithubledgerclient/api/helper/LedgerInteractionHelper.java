package it.eng.productunithubledgerclient.api.helper;

import it.eng.productunithubledgerclient.api.config.Chaincode;
import it.eng.productunithubledgerclient.api.config.ConfigManager;
import it.eng.productunithubledgerclient.api.config.Configuration;
import it.eng.productunithubledgerclient.api.config.Organization;
import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hyperledger.fabric.protos.peer.Query;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;

import java.io.File;
import java.util.*;

import static java.lang.String.format;

/**
 * @author ascatox
 */
final public class LedgerInteractionHelper {

    private final static Logger log = LogManager.getLogger(LedgerInteractionHelper.class);
    private HFClient client;
    private Channel channel;
    private ConfigManager configManager;
    private User user;
    private Organization organization;
    private Configuration configuration;
    private EventHandler eventHandler;


    File sampleStoreFile = new File(System.getProperty("java.io.tmpdir") + "/HFCSampletest.properties"); //FIXME

    public LedgerInteractionHelper(ConfigManager configManager, Organization organization) throws ProductUnitHubException {
        doChainInteractionHelper(configManager, organization, null);

    }

    public LedgerInteractionHelper(ConfigManager configManager, Organization organization, String userName) throws ProductUnitHubException {
        doChainInteractionHelper(configManager, organization, userName);

    }

    private void doChainInteractionHelper(ConfigManager configManager, Organization organization, String userName) throws ProductUnitHubException {
        try {
            //Create instance of client.
            client = HFClient.createNewInstance();
            client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
            this.configManager = configManager;
            this.organization = organization;
            this.configuration = configManager.getConfiguration();
            this.user = organization.getPeerAdminUser();
            if (StringUtils.isNotEmpty(userName)) {
                User user = organization.loadUser(userName);
                if (null != user)
                    this.user = user;
            }
            setup();
        } catch (Exception e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }
    }

    public void setup() throws Exception {
        ChannelInitializationManager channelInitializationManager = ChannelInitializationManager.getInstance(this.client, this.configManager, this.organization);
        Channel channel = channelInitializationManager.getChannel();
        if (null == channel || !channel.isInitialized() || channel.isShutdown()) {
            log.error("Channel is not initialized");
            throw new ProductUnitHubException("Channel is not initialized");
        }
        this.channel = channel;
        //FIXME EventHandling
        //this.eventHandler.register(this.channel, null);//FIXME Event Name
    }

    public void controlIntalledChaincodeOnPeers(Chaincode chaincode) throws ProductUnitHubException {
        log.debug( "Checking installed chaincode on all peer: %s, at version: %s, on peer: %s", chaincode.getName(), chaincode.getVersion(), channel.getPeers() );
        try {
            for ( Peer peer : channel.getPeers() ) {
                if (!checkInstalledChaincode( peer, chaincode )) {
                    throw new ProductUnitHubException(format( "Peer %s is missing chaincode whit name: %s, path: %s, version: %s",
                            peer.getName(), chaincode.getName(), chaincode.getPath(), chaincode.getVersion())  );
                }
            }
        }catch (Exception e) {
            throw new ProductUnitHubException( e );
        }
    }

    public boolean checkInstalledChaincode(Peer peer, Chaincode chaincode) throws InvalidArgumentException, ProposalException {
        log.debug("Checking installed chaincode: %s, at version: %s, on peer: %s", chaincode.getName(), chaincode.getVersion(), peer.getName());
        List<Query.ChaincodeInfo> ccinfoList = client.queryInstalledChaincodes(peer);
        boolean found = false;

        for (Query.ChaincodeInfo ccifo : ccinfoList) {
            if (chaincode.getPath() != null) {
                found = chaincode.getName().equals(ccifo.getName()) && chaincode.getPath().equals(ccifo.getPath()) && chaincode.getVersion().equals(ccifo.getVersion());
                if (found) {
                    break;
                }
            }
            found = chaincode.getName().equals(ccifo.getName()) && chaincode.getVersion().equals(ccifo.getVersion());
            if (found) {
                break;
            }
        }
        return found;
    }


    public void controlInstantiatedChaincode(Chaincode chaincode) throws  ProductUnitHubException{
        log.debug( "Checking instantiated chaincode on all peer: %s, at version: %s, on peer: %s", chaincode.getName(), chaincode.getVersion(), channel.getPeers() );
        try {
            for ( Peer peer : channel.getPeers() ) {
                if (!checkInstantiatedChaincode( peer, chaincode )) {
                    throw new ProductUnitHubException(format( "Peer %s is missing chaincode whit name: %s, path: %s, version: %s",
                            peer.getName(), chaincode.getName(), chaincode.getPath(), chaincode.getVersion())  );
                }
            }
        }catch (Exception e) {
            throw new ProductUnitHubException( e );
        }


    }

    public boolean checkInstantiatedChaincode(Peer peer, Chaincode chaincode) throws InvalidArgumentException, ProposalException {
        log.debug("Checking instantiated chaincode: %s, at version: %s, on peer: %s", chaincode.getName(), chaincode.getVersion(), peer.getName());
        List<Query.ChaincodeInfo> ccinfoList = this.channel.queryInstantiatedChaincodes(peer);

        boolean found = false;

        for (Query.ChaincodeInfo ccifo : ccinfoList) {

            if (chaincode.getPath() != null) {
                found = chaincode.getName().equals(ccifo.getName()) && chaincode.getPath().equals(ccifo.getPath()) && chaincode.getVersion().equals(ccifo.getVersion());
                if (found) {
                    break;
                }
            }
            found = chaincode.getName().equals(ccifo.getName()) && chaincode.getVersion().equals(ccifo.getVersion());
            if (found) {
                break;
            }
        }
        return found;

    }

    public InvokeReturn invokeChaincode(String functionName, ArrayList<String> args) throws ProductUnitHubException {
        try {
            //checkInstalledChaincode(configManager.getConfiguration().getChaincode());
            //checkInstantiatedChaincode(configManager.getConfiguration().getChaincode());

            Collection<ProposalResponse> successful = new LinkedList<>();
            Collection<ProposalResponse> failed = new LinkedList<>();

            ///////////////
            /// Send transaction proposal to all peers
            TransactionProposalRequest transactionProposalRequest = client.newTransactionProposalRequest();
            transactionProposalRequest.setChaincodeID(configuration.getChaincode().getChaincodeID());
            transactionProposalRequest.setFcn(functionName);
            transactionProposalRequest.setArgs(args);
            transactionProposalRequest.setProposalWaitTime(configManager.getProposalWaitTime());
            if (user != null) { // specific user use that
                transactionProposalRequest.setUserContext(user);
            }
            log.debug("sending transaction proposal to all peers with arguments:", args.get(0)); //FIXME
            String payload = null;
            Collection<ProposalResponse> invokePropResp = channel.sendTransactionProposal(transactionProposalRequest);
            for (ProposalResponse response : invokePropResp) {
                if (response.getStatus() == ChaincodeResponse.Status.SUCCESS) {
                    log.debug("Successful transaction proposal response Txid: %s from peer %s", response.getTransactionID(), response.getPeer().getName());
                    successful.add(response);
                    payload = response.getProposalResponse().getResponse().getPayload()
                            .toStringUtf8();
                } else {
                    failed.add(response);
                }
            }

            log.debug("Received %d transaction proposal responses. Successful+verified: %d . Failed: %d",
                    invokePropResp.size(), successful.size(), failed.size());
            if (failed.size() > 0) {
                ProposalResponse firstTransactionProposalResponse = failed.iterator().next();

                throw new ProposalException(format("Not enough endorsers for invoke(move a,b,%s):%d endorser error:%s. Was verified:%b",
                        args.get(0), firstTransactionProposalResponse.getStatus().getStatus(), firstTransactionProposalResponse.getMessage(), firstTransactionProposalResponse.isVerified()));

            }
            log.debug("Successfully received transaction proposal responses.");

            ////////////////////////////
            // Send transaction to orderer
            log.debug("Sending chaincode transaction to orderer.", args.get(0));
            if (user != null) {
                return new InvokeReturn(channel.sendTransaction(successful, user), payload);
            }
            return new InvokeReturn(channel.sendTransaction(successful), payload);
        } catch (Exception e) {

            throw new ProductUnitHubException(e);

        }
    }


    public List<QueryReturn> queryChainCode(String functionName, ArrayList<String> args, BlockEvent.TransactionEvent transactionEvent) throws ProductUnitHubException {
        try {
            if (null != transactionEvent) {
                //waitOnFabric(0);
                log.debug("Finished transaction with transaction id %s", transactionEvent.getTransactionID());
                String testTxID = transactionEvent.getTransactionID(); // used in the channel queries later
            }
            //checkInstalledChaincode(configManager.getConfiguration().getChaincode());
            //checkInstantiatedChaincode(configManager.getConfiguration().getChaincode());
            ////////////////////////////
            // Send Query Proposal to all peers
            //
            log.debug("Now query chaincode for the values rquired.");

            QueryByChaincodeRequest queryByChaincodeRequest = client.newQueryProposalRequest();
            queryByChaincodeRequest.setArgs(args);
            queryByChaincodeRequest.setFcn(functionName);
            queryByChaincodeRequest.setChaincodeID(configuration.getChaincode().getChaincodeID());

            Map<String, byte[]> tm2 = new HashMap<>();
            tm2.put("HyperLedgerFabric", "QueryByChaincodeRequest:JavaSDK".getBytes(configManager.UTF_8));
            tm2.put("method", "QueryByChaincodeRequest".getBytes(configManager.UTF_8));
            queryByChaincodeRequest.setTransientMap(tm2);
            List<QueryReturn> queryReturns = new ArrayList<>();

            Collection<ProposalResponse> queryProposals = channel.queryByChaincode(queryByChaincodeRequest, channel
                    .getPeers());
            for (ProposalResponse proposalResponse : queryProposals) {
                if (!proposalResponse.isVerified() || proposalResponse.getStatus() != ProposalResponse.Status
                        .SUCCESS) {
                    log.debug("Failed query proposal from peer " + proposalResponse.getPeer().getName() + " status: "
                            + proposalResponse.getStatus() +
                            ". Messages: " + proposalResponse.getMessage()
                            + ". Was verified : " + proposalResponse.isVerified());
                    QueryReturn queryReturn = new QueryReturn(proposalResponse.getPeer().getName(), null);
                    queryReturns.add(queryReturn);
                } else {
                    String payload = proposalResponse.getProposalResponse().getResponse().getPayload()
                            .toStringUtf8();
                    log.debug("Query payload from peer %s returned %s", proposalResponse.getPeer().getName(),
                            payload);
                    QueryReturn queryReturn = new QueryReturn(proposalResponse.getPeer().getName(), payload);
                    queryReturns.add(queryReturn);
                }
            }
            return queryReturns;
        } catch (Exception e) {
            log.error(e);
            throw new ProductUnitHubException("Failed during chaincode query with error : " + e.getMessage());
        }
    }


} //end class
