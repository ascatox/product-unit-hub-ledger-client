package it.eng.productunithubledgerclient.fabric.integration;

import it.eng.productunithubledgerclient.base.BlockchainFactory;
import it.eng.productunithubledgerclient.base.LedgerClient;
import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.model.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStreamReader;
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
        ProcessStep processStep= new ProcessStep();
        //Collection<ProcessStep> processStep = (Collection<ProcessStep>) new ProcessStep();
        WorkCellResource workCellResource = new WorkCellResource();
        workCellResource.setId("CTPP-01A");
        //workCellResource.setName( "omega" );
        processStep.setWorkCellResource(workCellResource);
        ArrayList<ProcessStep> processStepCollection = new ArrayList<>();
        processStepCollection.add( processStep );
        chassisDTO.setBillOfProcessSteps( processStepCollection );
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
        chassisDTO.setChassisId("A819631");
        chassisDTO.setComponent("CAB");
        chassisDTO.setSubComponent("TCAB");
        ProcessStep processStep = new ProcessStep();
        ArrayList<ProcessStep> processStepCollection = new ArrayList<>();
        processStepCollection.add( processStep );
        chassisDTO.setBillOfProcessSteps( processStepCollection );
        chassisDTOCollection.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOCollection);
            Collection<ProcessStep> chassisDTOCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(chassisDTOCollection1, chassisDTOCollection);
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void testOnlyGetProcessStep() {
        Collection<ChassisDTO> chassisDTOCollection = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId( "A819631" );
        chassisDTO.setComponent( "CAB" );
        chassisDTO.setSubComponent( "TCAB" );
        ProcessStep processStep = new ProcessStep();
        //Collection<ProcessStep> processStep = (Collection<ProcessStep>) new ProcessStep();
        WorkCellResource workCellResource = new WorkCellResource();
        workCellResource.setId( "CTPP-01A" );
        //workCellResource.setName( "omega" );
        processStep.setWorkCellResource( workCellResource );
        ArrayList<ProcessStep> processStepCollection = new ArrayList<>();
        processStepCollection.add( processStep );
        chassisDTO.setBillOfProcessSteps( processStepCollection );
        chassisDTOCollection.add( chassisDTO );
            //ledgerClient.storeProcessStepRouting(chassisDTOCollection);
        Collection<ProcessStep> chassisDTOCollection1 = null;
        try {
            chassisDTOCollection1 = ledgerClient.getProcessStep( chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent(), workCellResource.getId() );
        } catch (ProductUnitHubException e) {
            e.printStackTrace();
        }
        //assertEquals(chassisDTOCollection1, chassisDTOCollection);
            if (chassisDTOCollection1.isEmpty()) {
                System.out.println( "Process step is empty!!!!" );
            } else {
                System.out.println( "Test getProcessStep OK!!!" );
            }
            //assertFalse(e.getMessage(), true);
        }
    }









