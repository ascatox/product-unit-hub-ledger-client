package it.eng.productunithubledgerclient.fabric.integration;

import it.eng.productunithubledgerclient.base.BlockchainFactory;
import it.eng.productunithubledgerclient.base.LedgerClient;
import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.model.ChassisDTO;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author clod16
 */

public class End2EndStoreGetProcessStepRouting {

    static LedgerClient ledgerClient;

    @BeforeClass
    public static void begin() {
        try {
            BlockchainFactory factory = new BlockchainFactory();
            ledgerClient = factory.getType();
        } catch (ProductUnitHubException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void end() {
        ledgerClient = null;
    }


    @Test
    public void testStoreGetProcessSTepRoutng(){
        List<ChassisDTO> chassisDTOList = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("122333");
        chassisDTO.setComponent("wheel");
        chassisDTO.setSubComponent("round");
        chassisDTOList.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOList);
            Collection<ChassisDTO> processStepRoutings = ledgerClient.getProcessStepRouting(chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(chassisDTOList, processStepRoutings);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }
}


