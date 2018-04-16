package it.eng.productunithubledgerclient.fabric.integration;

import it.eng.productunithubledgerclient.base.BlockchainFactory;
import it.eng.productunithubledgerclient.base.LedgerClient;
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

/**
 * @author ascatox
 */
public class End2EndTest {

    static LedgerClient ledgerClient;
    static ProxyConfig proxyConfig;

    @BeforeClass
    public static void begin() {
        try {
            BlockchainFactory factory = new BlockchainFactory();
            ledgerClient = factory.getType();
            proxyConfig = new ProxyConfig();
            proxyConfig.Proxy();

        } catch (ProductUnitHubException e) {
            e.printStackTrace();
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
    public void testStoreGetProcessSTepRoutng() {
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

    @Test
    public void testGetProcessStepFullArgs() {
        Collection<ChassisDTO> chassisDTOCollection = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("1234");
        chassisDTO.setComponent("alpha");
        chassisDTO.setSubComponent("beta");
        ProcessStep processStep = new ProcessStep();
        WorkCellResource workCellResource = new WorkCellResource();
        workCellResource.setId("4321");
        //workCellResource.setName( "omega" );
        processStep.setWorkCellResource(workCellResource);
        chassisDTO.setBillOfProcessSteps((Collection<ProcessStep>) processStep);
        chassisDTOCollection.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOCollection);
            Collection<ProcessStep> chassisDTOCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent(), workCellResource.getId());
            assertEquals(chassisDTOCollection1, chassisDTOCollection);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void testGetProcessStep() {
        Collection<ChassisDTO> chassisDTOCollection = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("666");
        chassisDTO.setComponent("block");
        chassisDTO.setSubComponent("chain");
        ProcessStep processStep = new ProcessStep();
        chassisDTO.setBillOfProcessSteps((Collection<ProcessStep>) processStep);
        chassisDTOCollection.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOCollection);
            Collection<ProcessStep> chassisDTOCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(chassisDTOCollection1, chassisDTOCollection);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }

    }




}
