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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void testStoreProcessStepRouting() {
        List<ChassisDTO> chassisDTOList = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("A819631");
        chassisDTO.setComponent("CAB");
        chassisDTO.setSubComponent("TCAB");
        chassisDTOList.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOList);
            Collection<ChassisDTO> processStepRoutings = ledgerClient.getProcessStepRouting(chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(chassisDTOList, processStepRoutings);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }


    @Test
    public void testStoreProcessStepResult() {
        ProcessStepResultDTO processStepResultDTO = new ProcessStepResultDTO();
        OperationResult operationResult = new OperationResult();
        processStepResultDTO.getOperationResults().add(operationResult);
        try {
            ledgerClient.storeProcessStepResult(processStepResultDTO);
            ProcessStepResultDTO processStepResultDTO1 = ledgerClient.getProcessStepResult(processStepResultDTO.getChassisId(),
                    processStepResultDTO.getComponent(), processStepResultDTO.getSubComponent(), processStepResultDTO.getWorkcellResourceId());
            assertEquals(processStepResultDTO, processStepResultDTO1);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    //@Test
    public void testStoreProcessStepRoutingJSON() {
        String json = "";
        List<ChassisDTO> chassisDTOList = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("A819851");
        chassisDTO.setComponent("CAB");
        chassisDTO.setSubComponent("TCAB");
        chassisDTOList.add(chassisDTO);
        JsonConverter jsonConverter = new JsonConverter();
        try {
            ledgerClient.storeProcessStepRouting(json);
            Collection<ChassisDTO> processStepRoutings = ledgerClient.getProcessStepRouting(chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(json, jsonConverter.convertToJson(processStepRoutings));
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }

    }


    //@Test
    public void storeProcessStepResult() {


    }


    @Test
    public void testStoreGetProcessStepRouting() {
        List<ChassisDTO> chassisDTOList = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("A819631");
        chassisDTO.setComponent("CAB");
        chassisDTO.setSubComponent("TCAB");
        chassisDTOList.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOList);
            Collection<ChassisDTO> processStepRoutings = ledgerClient.getProcessStepRouting(chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(chassisDTOList, processStepRoutings);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void testGetProcessStepFullArgs() {
        Collection<ChassisDTO> chassisDTOCollection = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("A819631");
        chassisDTO.setComponent("CAB");
        chassisDTO.setSubComponent("TCAB");
        chassisDTO.setProductUnits("0000123cab");
        ProcessStep processStep = new ProcessStep();
        processStep.setId("001_8415E5D-47A2-4E79-BF1C-1F56B105AC6");
        processStep.setName("New ALF in TAS");
        WorkcellResource workcellResource = new WorkcellResource();
        workcellResource.setId("CTPP-01A");
        processStep.setWorkcellResource(workcellResource);
        ArrayList<ProcessStep> processStepCollection = new ArrayList<>();
        processStepCollection.add(processStep);
        chassisDTO.setBillOfProcessSteps(processStepCollection);
        chassisDTOCollection.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOCollection);
            Collection<ProcessStep> processStepCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent(), workcellResource.getId());
            assertEquals(processStepCollection1, processStepCollection);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void testGetProcessStep() {
        Collection<ChassisDTO> chassisDTOCollection = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("A819631");
        chassisDTO.setComponent("CAB");
        chassisDTO.setSubComponent("TCAB");
        ProcessStep processStep = new ProcessStep();
        processStep.setId("001_8415E5D-47A2-4E79-BF1C-1F56B105AC6");
        processStep.setName("New ALF in TAS");
        ArrayList<ProcessStep> processStepCollection = new ArrayList<>();
        processStepCollection.add(processStep);
        chassisDTO.setBillOfProcessSteps(processStepCollection);
        chassisDTOCollection.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOCollection);
            Collection<ProcessStep> processStepCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(processStepCollection, processStepCollection1);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void testOnlyGetProcessStep() {
        Collection<ChassisDTO> chassisDTOCollection = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("A819631");
        chassisDTO.setComponent("CAB");
        chassisDTO.setSubComponent("TCAB");
        ProcessStep processStep = new ProcessStep();
        processStep.setId("001_8415E5D-47A2-4E79-BF1C-1F56B105AC6");
        processStep.setName("New ALF in TAS");
        WorkcellResource workcellResource = new WorkcellResource();
        workcellResource.setId("CTPP-01A");
        processStep.setWorkcellResource(workcellResource);
        ArrayList<ProcessStep> processStepCollection = new ArrayList<>();
        processStepCollection.add(processStep);
        chassisDTO.setBillOfProcessSteps(processStepCollection);
        chassisDTOCollection.add(chassisDTO);
        //ledgerClient.storeProcessStepRouting(chassisDTOCollection);
        Collection<ProcessStep> chassisDTOCollection1 = null;
        try {
            chassisDTOCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent(), workcellResource.getId());
        } catch (ProductUnitHubException e) {
            e.printStackTrace();
            assertFalse(e.getMessage(), true);
        }
        //assertEquals(chassisDTOCollection1, chassisDTOCollection);
        if (chassisDTOCollection1.isEmpty()) {
            System.out.println("Process step is empty!!!!");
            assertFalse("Process step is empty!!!!", true);
        } else {
            System.out.println("Test getProcessStep OK!!!");
            assertTrue("Test getProcessStep OK!!!", true);

        }
        //assertFalse(e.getMessage(), true);
    }
}









