package it.eng.productunithubledgerclient.fabric.integration;

import it.eng.productunithubledgerclient.base.BlockchainFactory;
import it.eng.productunithubledgerclient.base.LedgerClient;
import it.eng.productunithubledgerclient.convert.JsonConverter;
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
    public void testStoreProcessStepResult(){
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
    public void testStoreProcessStepRoutingJSON(){
        String json = "{  \"ChassisId\": \"A819851\",  \"Component\": \"CAB\",  \"SubComponent\": \"TCAB\",  \"ProductUnits\": null,  \"BillOfProcessSteps\": [    {      \"SequenceNo\": 1,      \"PlannedProductionTime\": 0,      \"WorkcellResource\": {        \"Id\": \"ALF-ONA\",        \"Name\": \"ALF-ONA\"      },      \"BillOfOperation\": [        {          \"SequenceNo\": 1,          \"InstructionTexts\": null,          \"EquipmentRequirements\": null,          \"OperationSteps\": [            {              \"SequenceNo\": 1,              \"InstructionTexts\": [                {                  \"SequenceNo\": 1,                  \"Text\": \"F1, D1, T1\",                  \"RTF\": \"\"                }              ],              \"EquipmentRequirements\": [                {                  \"SequenceNo\": 1,                  \"EquipmentType\": \"EQ\",                  \"Specifications\": [                    {                      \"SequenceNo\": 1,                      \"Specification\": \"ALF\",                      \"Value\": \"\",                      \"Quantity\": 1,                      \"Parameters\": [                        {                          \"Group\": \"1\",                          \"Id\": \"1\",                          \"Value\": \"F1,D1,T1\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"2\",                          \"Value\": \"L\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"3\",                          \"Value\": \"D1\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"5\",                          \"Value\": \"Y\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"6\",                          \"Value\": \"Y\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"7\",                          \"Value\": \"Y\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"8\",                          \"Value\": \"Y\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"9\",                          \"Value\": \"Y\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"11\",                          \"Value\": \"-1297\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"12\",                          \"Value\": \"303\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"13\",                          \"Value\": \"590\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"14\",                          \"Value\": \"375\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"15\",                          \"Value\": \"-1365\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"16\",                          \"Value\": \"-982\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"17\",                          \"Value\": \"3\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"18\",                          \"Value\": \"Y\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"20\",                          \"Value\": \"852\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"21\",                          \"Value\": \"1190\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"22\",                          \"Value\": \"1\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"23\",                          \"Value\": \"1,5\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"24\",                          \"Value\": \"0\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"101\",                          \"Value\": \"0\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"102\",                          \"Value\": \"0\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"103\",                          \"Value\": \"0,2\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"104\",                          \"Value\": \"1,3\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"105\",                          \"Value\": \"1\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"107\",                          \"Value\": \"0,5\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"112\",                          \"Value\": \"385-55\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"113\",                          \"Value\": \"22,5\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"114\",                          \"Value\": \"Set\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"115\",                          \"Value\": \"Y\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"401\",                          \"Value\": \"3700\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"402\",                          \"Value\": \"0\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"403\",                          \"Value\": \"0,2\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"412\",                          \"Value\": \"315-70\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"413\",                          \"Value\": \"22,5\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"414\",                          \"Value\": \"Measured\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"415\",                          \"Value\": \"Y\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"601\",                          \"Value\": \"1370\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"602\",                          \"Value\": \"2\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"603\",                          \"Value\": \"0,2\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"604\",                          \"Value\": \"1,7\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"605\",                          \"Value\": \"1\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"607\",                          \"Value\": \"2\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"612\",                          \"Value\": \"385-55\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"613\",                          \"Value\": \"22,5\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"614\",                          \"Value\": \"Measured\"                        },                        {                          \"Group\": \"1\",                          \"Id\": \"615\",                          \"Value\": \"Y\"                        }                      ]                    }                  ]                }              ],              \"BillOfMaterial\": null,              \"Description\": \"F1, D1, T1\"            }          ],          \"Id\": \"001_8415E5D-47A2-4E79-BF1C-1F56B105AC6    _001\",          \"CIN\": \"178077\",          \"Description\": \"Axle arrangement (1, 24)\",          \"OperationType\": \"AI\"        }      ],      \"Id\": \"001_8415E5D-47A2-4E79-BF1C-1F56B105AC6\",      \"Name\": \"New ALF in TAS\"    }  ]}";
        List<ChassisDTO> chassisDTOList = new ArrayList<>();
        ChassisDTO chassisDTO = new ChassisDTO();
        chassisDTO.setChassisId("A819851");
        chassisDTO.setComponent("CAB");
        chassisDTO.setSubComponent("TCAB");
        chassisDTOList.add(chassisDTO);
        JsonConverter jsonConverter = new JsonConverter();
        try{
            ledgerClient.storeProcessStepRouting( json );
            Collection<ChassisDTO> processStepRoutings = ledgerClient.getProcessStepRouting(chassisDTO.getComponent(), chassisDTO.getSubComponent());
            assertEquals(json, jsonConverter.convertToJson( processStepRoutings ));
        } catch (ProductUnitHubException e) {
            assertFalse(e.getMessage(), true);
        }

    }


    @Test
    public void storeProcessStepResult(){




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









