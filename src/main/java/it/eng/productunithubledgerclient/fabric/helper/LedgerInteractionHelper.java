package it.eng.productunithubledgerclient.fabric.helper;

import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.fabric.config.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hyperledger.fabric.protos.peer.Query;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;

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
    private UserManager userManager;
    private Organization organization;
    private Configuration configuration;
    private EventHandler eventHandler;


    //File sampleStoreFile = new File(System.getProperty("java.io.tmpdir") + "/HFCSampletest.properties"); //FIXME

    public LedgerInteractionHelper(ConfigManager configManager, Organization organization) throws ProductUnitHubException {
        this(configManager, organization, null);

    }

    public LedgerInteractionHelper(ConfigManager configManager, Organization organization, String userName) throws ProductUnitHubException {
        try {
            //Create instance of client.
            client = HFClient.createNewInstance();
            client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
            this.configManager = configManager;
            this.organization = organization;
            this.configuration = configManager.getConfiguration();
            this.userManager = UserManager.getInstance(configuration, organization);
            this.userManager.completeUsers();
            setup();
        } catch (Exception e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }
    }

    private void setup() throws Exception {
        ChannelInitializationManager channelInitializationManager = ChannelInitializationManager.getInstance(this.client, this.configManager, this.organization);
        Channel channel = channelInitializationManager.getChannel();
        if (null == channel || !channel.isInitialized() || channel.isShutdown()) {
            log.error("Channel is not initialized");
            throw new ProductUnitHubException("Channel is not initialized");
        }
        this.channel = channel;
        //FIXME EventHandling
        this.eventHandler = EventHandler.getInstance();
        //this.eventHandler.register(this.channel, null);//TODO Event Name

        this.controlInstalledChaincodeOnPeers(configuration.getChaincode());
        this.controlInstantiatedChaincodeOnPeers(configuration.getChaincode());
    }

    public void controlInstalledChaincodeOnPeers(Chaincode chaincode) throws ProductUnitHubException {
        log.debug("Checking installed chaincode on all peer: %s, at version: %s, on peer: %s", chaincode.getName(), chaincode.getVersion(), channel.getPeers());
        for (Peer peer : channel.getPeers()) {
            try {
                if (!checkInstalledChaincode(peer, chaincode)) {
                    throw new ProductUnitHubException(format("Peer %s is missing chaincode whith name: %s, path: %s, version: %s",
                            peer.getName(), chaincode.getName(), chaincode.getPath(), chaincode.getVersion()));
                }
            } catch (ProductUnitHubException e) {
                log.error(e);
                throw new ProductUnitHubException(format("Peer %s is missing chaincode whith name: %s, path: %s, version: %s",
                        peer.getName(), chaincode.getName(), chaincode.getPath(), chaincode.getVersion()));
            }
        }
    }

    private boolean checkInstalledChaincode(Peer peer, Chaincode chaincode) throws ProductUnitHubException {
        log.debug("Checking installed chaincode: %s, at version: %s, on peer: %s", chaincode.getName(), chaincode.getVersion(), peer.getName());
        boolean found = false;
        try {
            List<Query.ChaincodeInfo> ccinfoList = null;
            ccinfoList = client.queryInstalledChaincodes(peer);
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
        } catch (InvalidArgumentException | ProposalException e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }
        return found;
    }

    public void controlInstantiatedChaincodeOnPeers(Chaincode chaincode) throws ProductUnitHubException {
        log.debug("Checking installed chaincode on all peer: %s, at version: %s, on peer: %s", chaincode.getName(), chaincode.getVersion(), channel.getPeers());
        for (Peer peer : channel.getPeers()) {
            if (!checkInstantiatedChaincode(peer, chaincode)) {
                try {
                    throw new ProductUnitHubException(format("Peer %s has not installed chaincode with name: %s, path: %s, version: %s",
                            peer.getName(), chaincode.getName(), chaincode.getPath(), chaincode.getVersion()));
                } catch (ProductUnitHubException e) {
                    log.error(e);
                    throw new ProductUnitHubException(format("Peer %s has not installed chaincode with name: %s, path: %s, version: %s",
                            peer.getName(), chaincode.getName(), chaincode.getPath(), chaincode.getVersion()));
                }
            }
        }
    }

    private boolean checkInstantiatedChaincode(Peer peer, Chaincode chaincode) throws ProductUnitHubException {
        log.debug("Checking instantiated chaincode: %s, at version: %s, on peer: %s", chaincode.getName(), chaincode.getVersion(), peer.getName());
        boolean found = false;
        try {
            List<Query.ChaincodeInfo> ccinfoList = null;

            ccinfoList = this.channel.queryInstantiatedChaincodes(peer);
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
        } catch (InvalidArgumentException | ProposalException e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }
        return found;

    }

    public InvokeReturn invokeChaincode(String functionName, List<String> args) throws ProductUnitHubException {
        try {
            User user = organization.getLoggedUser();
            Collection<ProposalResponse> successful = new LinkedList<>();
            Collection<ProposalResponse> failed = new LinkedList<>();

            String[] argsArr = new String[args.size()];
            argsArr = args.toArray(argsArr);

            ///////////////
            /// Send transaction proposal to all peers
            TransactionProposalRequest transactionProposalRequest = client.newTransactionProposalRequest();
            transactionProposalRequest.setChaincodeID(configuration.getChaincode().getChaincodeID());
            transactionProposalRequest.setFcn(functionName);
            transactionProposalRequest.setArgs(argsArr);
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
            // Send transaction to orderer
            log.debug("Sending chaincode transaction to orderer.", args.get(0));
            if (user != null) {
                return new InvokeReturn(channel.sendTransaction(successful, user), payload);
            }
            return new InvokeReturn(channel.sendTransaction(successful), payload);
        } catch (Exception e) {
            log.error(e);
            throw new ProductUnitHubException(e);

        }
    }


    public List<QueryReturn> queryChainCode(String functionName, List<String> args, BlockEvent.TransactionEvent transactionEvent) throws ProductUnitHubException {
        try {
            if (null != transactionEvent) {
                //waitOnFabric(0);
                log.debug("Finished transaction with transaction id %s", transactionEvent.getTransactionID());
                String testTxID = transactionEvent.getTransactionID(); // used in the channel queries later
            }
            // Send Query Proposal to all peers
            //
            log.debug("Now query chaincode for the values rquired.");

            String[] argsArr = new String[args.size()];
            argsArr = args.toArray(argsArr);

            QueryByChaincodeRequest queryByChaincodeRequest = client.newQueryProposalRequest();
            queryByChaincodeRequest.setArgs(argsArr);
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

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }


} //end class
