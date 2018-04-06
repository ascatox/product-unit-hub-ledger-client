package it.eng.productunithubledgerclient.fabric.integration;

import it.eng.productunithubledgerclient.base.BlockchainFactory;
import it.eng.productunithubledgerclient.base.LedgerClient;
import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.model.ChassisDTO;
import it.eng.productunithubledgerclient.model.OperationResult;
import it.eng.productunithubledgerclient.model.ProcessStepResultDTO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author ascatox
 */
public class End2EndTest {

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
    public void testStoreProcessStepResult() {
        ProcessStepResultDTO processStepResultDTO = new ProcessStepResultDTO();
        OperationResult operationResult = new OperationResult();
        processStepResultDTO.getOperationResults().add(operationResult);
        try {
            ledgerClient.storeProcessStepResult(processStepResultDTO);
            ProcessStepResultDTO processStepResultDTO1 = ledgerClient.getProcessStepResult(processStepResultDTO.getChassisId(),
                    processStepResultDTO.getComponent(), processStepResultDTO.getSubComponent(), processStepResultDTO.getWorkCellResourceId());
            assertEquals(processStepResultDTO, processStepResultDTO1);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }


    @Test
    public void testStoreProcessStepRouting() {
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
