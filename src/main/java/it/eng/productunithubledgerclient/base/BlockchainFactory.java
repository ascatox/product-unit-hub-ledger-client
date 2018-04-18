package it.eng.productunithubledgerclient.base;

import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.fabric.FabricLedgerClient;

import java.util.ResourceBundle;

/**
 * @author ascatox
 * This class decides the type of blockchain we can implement
 */
public final class BlockchainFactory {
    /**
     * @param type describer the type of blockchain
     */
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private static String type = resourceBundle.getString("BLOCKCHAIN_TYPE");

    public LedgerClient getType(BlockchainType blockchainType) throws ProductUnitHubException {
        if (blockchainType.equals(BlockchainType.HL_FABRIC))
            return new FabricLedgerClient();
        return null;

    }

    public LedgerClient getType() throws ProductUnitHubException {
        if (type.equalsIgnoreCase(BlockchainType.HL_FABRIC.name()))
            return new FabricLedgerClient();
        return null;

    }
}
