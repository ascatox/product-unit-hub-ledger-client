package it.eng.productunithubledgerclient.fabric.integration;

import it.eng.productunithubledgerclient.base.BlockchainFactory;
import it.eng.productunithubledgerclient.base.LedgerClient;
import it.eng.productunithubledgerclient.convert.JsonConverter;
import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.model.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

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
            //ProxyConfig.setProxy();
            BlockchainFactory factory = new BlockchainFactory();
            ledgerClient = factory.getType();

        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @AfterClass
    public static void end() {
        ledgerClient = null;
    }


    @Test
    public void testStoreGetProcessStepResult() {
        final ProcessStepResultDTO processStepResultDTO = buildProcessStepResultDTO();
        try {
            ledgerClient.storeProcessStepResult(processStepResultDTO);
            ProcessStepResultDTO processStepResultDTO1 = ledgerClient.getProcessStepResult(processStepResultDTO.getChassisId(),
                    processStepResultDTO.getComponent(), processStepResultDTO.getSubComponent(), processStepResultDTO.getWorkcellResourceId());
            assertEquals(processStepResultDTO, processStepResultDTO1);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void testStoreProcessStepRoutingJSON() {
        List<ChassisDTO> chassisDTOList = new ArrayList<>();
        final ChassisDTO chassisDTO = buildChassisDTO();
        chassisDTOList.add(chassisDTO);
        try {
            String json = JsonConverter.convertToJson(chassisDTOList);
            ledgerClient.storeProcessStepRouting(json);
            Collection<ChassisDTO> processStepRoutings = ledgerClient.getProcessStepRouting(chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(json, JsonConverter.convertToJson(processStepRoutings));
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }

    }

    @Test
    public void testStoreGetProcessStepRouting() {
        Collection<ChassisDTO> chassisDTOList = new ArrayList<>();
        final ChassisDTO chassisDTO = buildChassisDTO();
        chassisDTOList.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOList);
            Collection<ChassisDTO> chassisDTOList1 = ledgerClient.getProcessStepRouting(chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(chassisDTOList, chassisDTOList1);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void testStoreGetProcessStepRoutingFullArgs() {
        Collection<ChassisDTO> chassisDTOList = new ArrayList<>();
        final ChassisDTO chassisDTO = buildChassisDTO();
        chassisDTOList.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOList);
            ChassisDTO chassisDTO1 = ledgerClient.getProcessStepRouting(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(chassisDTO, chassisDTO1);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void testGetProcessStepFullArgs() {
        Collection<ChassisDTO> chassisDTOCollection = new ArrayList<>();
        final ChassisDTO chassisDTO = buildChassisDTO();
        chassisDTOCollection.add(chassisDTO);
        List<ProcessStep> processSteps = (List<ProcessStep>) chassisDTO.getBillOfProcessSteps();
        WorkcellResource workcellResource = processSteps.get(0).getWorkcellResource();
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOCollection);
            Collection<ProcessStep> processStepCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent(), workcellResource.getId());
            assertEquals(processStepCollection1, chassisDTO.getBillOfProcessSteps());
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void testGetProcessStep() {
        Collection<ChassisDTO> chassisDTOCollection = new ArrayList<>();
        final ChassisDTO chassisDTO = buildChassisDTO();
        chassisDTOCollection.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOCollection);
            Collection<ProcessStep> processStepCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(chassisDTO.getBillOfProcessSteps(), processStepCollection1);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }


    private int getNextInt() {
        Random rand = new Random();
        return rand.nextInt(100);
    }



    private ChassisDTO buildChassisDTO() {
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("A819631_" + getNextInt());
        chassisDTO.setComponent("CAB_" + getNextInt());
        chassisDTO.setSubComponent("TCAB_" + getNextInt());
        ProcessStep processStep = new ProcessStep();
        processStep.setId("001_8415E5D-47A2-4E79-BF1C-1F56B105AC6-" + getNextInt());
        processStep.setName("New ALF in TAS");
        processStep.setSequenceNo(getNextInt());
        WorkcellResource workcellResource = new WorkcellResource();
        workcellResource.setId("CTPP-01A-" + getNextInt());
        processStep.setWorkcellResource(workcellResource);
        ArrayList<ProcessStep> processStepCollection = new ArrayList<>();
        processStepCollection.add(processStep);
        chassisDTO.getBillOfProcessSteps().add(processStep);
        return chassisDTO;
    }


    private ProcessStepResultDTO buildProcessStepResultDTO() {
        ProcessStepResultDTO processStepResultDTO = new ProcessStepResultDTO();
        processStepResultDTO.setChassisId("alpha" + getNextInt());
        processStepResultDTO.setComponent("beta" + getNextInt());
        processStepResultDTO.setSubComponent("omega" + getNextInt());
        processStepResultDTO.setWorkcellResourceId("lambda" + getNextInt());
        OperationResult operationResult = new OperationResult();
        OperationStepResult operationStepResult = new OperationStepResult();
        operationStepResult.setChannelId("AAA");
        operationStepResult.setSequenceNo(getNextInt());
        operationResult.getOperationStepResults().add(operationStepResult);
        processStepResultDTO.getOperationResults().add(operationResult);
        return processStepResultDTO;
    }
}









