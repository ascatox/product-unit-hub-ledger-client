package it.eng.productunithubledgerclient.base;

import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.fabric.FabricLedgerClient;

import java.io.IOException;
import java.util.Properties;

/**
 * @author ascatox
 * This class decides the type of blockchain we can implement
 */
public final class BlockchainFactory {
    /**
     * @param type describer the type of blockchain
     */
    //private static Properties resourceBundle = ResourceBundle.getBundle("application", java.util.Locale.getDefault());
    private static Properties properties = null;
    private static String type = "";

    static {
        try {
            properties = new Properties();
            properties.load(BlockchainFactory.class.getResourceAsStream("/application.properties"));
            type = properties.getProperty("BLOCKCHAIN_TYPE");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LedgerClient getType(BlockchainType blockchainType) throws ProductUnitHubException {
        if (blockchainType.equals(BlockchainType.HL_FABRIC))
            return new FabricLedgerClient();
        return null;

    }

    public LedgerClient getType() throws ProductUnitHubException {
        if (BlockchainType.HL_FABRIC.name().equals(type))
            return new FabricLedgerClient();
        else
            return new FabricLedgerClient();
    }
}
