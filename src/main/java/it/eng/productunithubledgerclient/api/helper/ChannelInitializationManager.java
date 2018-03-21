package it.eng.productunithubledgerclient.api.helper;

import it.eng.productunithubledgerclient.api.config.ConfigManager;
import it.eng.productunithubledgerclient.api.config.Orderer;
import it.eng.productunithubledgerclient.api.config.Organization;
import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.EventHub;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.TransactionException;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author ascatox
 */
public class ChannelInitializationManager {
    private final static Logger log = LogManager.getLogger(ChannelInitializationManager.class);

    private ConfigManager configManager;
    private HFClient client;
    private Channel channel;
    private Organization organization;

    public ChannelInitializationManager(HFClient client, Channel channel, Organization organization) {
        this.client = client;
        this.channel = channel;
        this.organization = organization;
    }


    public Channel initializeChannel() throws ProductUnitHubException {
        ////////////////////////////
        //Initialize the channel
        //
        try {
            log.debug("Constructing channel java structures %s", channel.getName());
            //Only peer Admin org
            client.setUserContext(organization.getPeerAdminUser());

            buildOrderers(organization.getOrderers());

            buildPeers(organization.getPeers());

            buildEventHubs(organization.getPeers());

            channel.initialize(); //There's no need to initialize the channel we are only building the java
            // structures.
            log.debug("Finished initialization channel java structures %s", channel.getName());
            return channel;
        } catch (InvalidArgumentException | TransactionException e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }

    }

    //@ascatox Pay attention!!! EventHubs are the same as Peers with different urls
    private void buildEventHubs(List<it.eng.productunithubledgerclient.api.config.Peer> peerList) throws InvalidArgumentException {
        for (it.eng.productunithubledgerclient.api.config.Peer peerObj : peerList) {

            final Properties eventHubProperties = configManager.getEventHubProperties(peerObj.getName());

            eventHubProperties.put("grpc.NettyChannelBuilderOption.keepAliveTime", new Object[]{5L, TimeUnit
                    .MINUTES});
            eventHubProperties.put("grpc.NettyChannelBuilderOption.keepAliveTimeout", new Object[]{8L, TimeUnit
                    .SECONDS});

            EventHub eventHub = client.newEventHub(peerObj.getName(), peerObj.getEventURL(), eventHubProperties);
            channel.addEventHub(eventHub);
        }
    }

    private void buildPeers(List<it.eng.productunithubledgerclient.api.config.Peer> peerList) throws InvalidArgumentException {
        for (it.eng.productunithubledgerclient.api.config.Peer peerObj : peerList) {
            String peerLocation = peerObj.getRequestURL();

            Properties peerProperties = configManager.getPeerProperties(peerObj.getName()); //CaUser properties for
            // peer.. if
            // any.
            if (peerProperties == null) {
                peerProperties = new Properties();
            }
            //Example of setting specific options on grpc's NettyChannelBuilder
            peerProperties.put("grpc.NettyChannelBuilderOption.maxInboundMessageSize", 9000000);

            Peer peer = client.newPeer(peerObj.getName(), peerLocation, peerProperties);
            //            newChannel.joinPeer(peer);
            channel.addPeer(peer);
            //org.addPeer(peer);
        }
    }

    private void buildOrderers(List<Orderer> orderersConfig) throws InvalidArgumentException {
        List<org.hyperledger.fabric.sdk.Orderer> orderers = new LinkedList<>();
        for (Orderer orderer : orderersConfig) {

            Properties ordererProperties = configManager.getOrdererProperties(orderer.getName());
            //example of setting keepAlive to avoid timeouts on inactive http2 connections.
            // Under 5 minutes would require changes to server side to accept faster ping rates.
            ordererProperties.put("grpc.NettyChannelBuilderOption.keepAliveTime", new Object[]{5L, TimeUnit
                    .MINUTES});
            ordererProperties.put("grpc.NettyChannelBuilderOption.keepAliveTimeout", new Object[]{8L, TimeUnit
                    .SECONDS});
            orderers.add(client.newOrderer(orderer.getName(), orderer.getUrl(), ordererProperties));
        }
        org.hyperledger.fabric.sdk.Orderer anOrderer = orderers.iterator().next();
        //Just pick the first orderer in the list to create the channel.
        channel.addOrderer(anOrderer);
        for (org.hyperledger.fabric.sdk.Orderer orderer : orderers) { //add remaining orderers if any.
            if (!orderer.equals(anOrderer))
                channel.addOrderer(orderer);
        }

    }
}
