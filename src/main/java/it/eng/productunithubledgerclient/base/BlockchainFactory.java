package it.eng.productunithubledgerclient.base;

import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.fabric.FabricLedgerClient;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author ascatox
 * This class decides the type of blockchain we can implement
 */
public final class BlockchainFactory {
    /**
     * @param type describer the type of blockchain
     */
    //private static Properties resourceBundle = ResourceBundle.getBundle("application", java.util.Locale.getDefault());
    private static Properties properties = new Properties();
    /*static {
        try {
            properties.load(BlockchainFactory.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    private static String type =  properties.getProperty("BLOCKCHAIN_TYPE");

    public LedgerClient getType(BlockchainType blockchainType) throws ProductUnitHubException {
        if (blockchainType.equals(BlockchainType.HL_FABRIC))
            return new FabricLedgerClient();
        return null;

    }

    public LedgerClient getType() throws ProductUnitHubException {
       // if (type.equalsIgnoreCase(BlockchainType.HL_FABRIC.name()))
            return new FabricLedgerClient();
       // else
        //    return new FabricLedgerClient();
        //return null;

    }
}
