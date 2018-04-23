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
    public void testStoreProcessStepRoutingJSON() {
        String json = "{  \"ChassisId\": \"A819851\",  \"Component\": \"CAB\",  \"SubComponent\": \"TCAB\",  \"ProductUnits\": null,  \"BillOfProcessSteps\": [    {      \"sequenceNo\": 1,      \"PlannedProductionTime\": 0,      \"WorkcellResource\": {        \"id\": \"ALF-ONA\",        \"Name\": \"ALF-ONA\"      },      \"BillOfOperation\": [        {          \"sequenceNo\": 1,          \"InstructionTexts\": null,          \"EquipmentRequirements\": null,          \"OperationSteps\": [            {              \"sequenceNo\": 1,              \"InstructionTexts\": [                {                  \"sequenceNo\": 1,                  \"Text\": \"F1, D1, T1\",                  \"RTF\": \"\"                }              ],              \"EquipmentRequirements\": [                {                  \"sequenceNo\": 1,                  \"EquipmentType\": \"EQ\",                  \"Specifications\": [                    {                      \"sequenceNo\": 1,                      \"specification\": \"ALF\",                      \"value\": \"\",                      \"quantity\": 1,                      \"parameters\": [                        {                          \"group\": \"1\",                          \"id\": \"1\",                          \"value\": \"F1,D1,T1\"                        },                        {                          \"group\": \"1\",                          \"id\": \"2\",                          \"value\": \"L\"                        },                        {                          \"group\": \"1\",                          \"id\": \"3\",                          \"value\": \"D1\"                        },                        {                          \"group\": \"1\",                          \"id\": \"5\",                          \"value\": \"Y\"                        },                        {                          \"group\": \"1\",                          \"id\": \"6\",                          \"value\": \"Y\"                        },                        {                          \"group\": \"1\",                          \"id\": \"7\",                          \"value\": \"Y\"                        },                        {                          \"group\": \"1\",                          \"id\": \"8\",                          \"value\": \"Y\"                        },                        {                          \"group\": \"1\",                          \"id\": \"9\",                          \"value\": \"Y\"                        },                        {                          \"group\": \"1\",                          \"id\": \"11\",                          \"value\": \"-1297\"                        },                        {                          \"group\": \"1\",                          \"id\": \"12\",                          \"value\": \"303\"                        },                        {                          \"group\": \"1\",                          \"id\": \"13\",                          \"value\": \"590\"                        },                        {                          \"group\": \"1\",                          \"id\": \"14\",                          \"value\": \"375\"                        },                        {                          \"group\": \"1\",                          \"id\": \"15\",                          \"value\": \"-1365\"                        },                        {                          \"group\": \"1\",                          \"id\": \"16\",                          \"value\": \"-982\"                        },                        {                          \"group\": \"1\",                          \"id\": \"17\",                          \"value\": \"3\"                        },                        {                          \"group\": \"1\",                          \"id\": \"18\",                          \"value\": \"Y\"                        },                        {                          \"group\": \"1\",                          \"id\": \"20\",                          \"value\": \"852\"                        },                        {                          \"group\": \"1\",                          \"id\": \"21\",                          \"value\": \"1190\"                        },                        {                          \"group\": \"1\",                          \"id\": \"22\",                          \"value\": \"1\"                        },                        {                          \"group\": \"1\",                          \"id\": \"23\",                          \"value\": \"1,5\"                        },                        {                          \"group\": \"1\",                          \"id\": \"24\",                          \"value\": \"0\"                        },                        {                          \"group\": \"1\",                          \"id\": \"101\",                          \"value\": \"0\"                        },                        {                          \"group\": \"1\",                          \"id\": \"102\",                          \"value\": \"0\"                        },                        {                          \"group\": \"1\",                          \"id\": \"103\",                          \"value\": \"0,2\"                        },                        {                          \"group\": \"1\",                          \"id\": \"104\",                          \"value\": \"1,3\"                        },                        {                          \"group\": \"1\",                          \"id\": \"105\",                          \"value\": \"1\"                        },                        {                          \"group\": \"1\",                          \"id\": \"107\",                          \"value\": \"0,5\"                        },                        {                          \"group\": \"1\",                          \"id\": \"112\",                          \"value\": \"385-55\"                        },                        {                          \"group\": \"1\",                          \"id\": \"113\",                          \"value\": \"22,5\"                        },                        {                          \"group\": \"1\",                          \"id\": \"114\",                          \"value\": \"Set\"                        },                        {                          \"group\": \"1\",                          \"id\": \"115\",                          \"value\": \"Y\"                        },                        {                          \"group\": \"1\",                          \"id\": \"401\",                          \"value\": \"3700\"                        },                        {                          \"group\": \"1\",                          \"id\": \"402\",                          \"value\": \"0\"                        },                        {                          \"group\": \"1\",                          \"id\": \"403\",                          \"value\": \"0,2\"                        },                        {                          \"group\": \"1\",                          \"id\": \"412\",                          \"value\": \"315-70\"                        },                        {                          \"group\": \"1\",                          \"id\": \"413\",                          \"value\": \"22,5\"                        },                        {                          \"group\": \"1\",                          \"id\": \"414\",                          \"value\": \"Measured\"                        },                        {                          \"group\": \"1\",                          \"id\": \"415\",                          \"value\": \"Y\"                        },                        {                          \"group\": \"1\",                          \"id\": \"601\",                          \"value\": \"1370\"                        },                        {                          \"group\": \"1\",                          \"id\": \"602\",                          \"value\": \"2\"                        },                        {                          \"group\": \"1\",                          \"id\": \"603\",                          \"value\": \"0,2\"                        },                        {                          \"group\": \"1\",                          \"id\": \"604\",                          \"value\": \"1,7\"                        },                        {                          \"group\": \"1\",                          \"id\": \"605\",                          \"value\": \"1\"                        },                        {                          \"group\": \"1\",                          \"id\": \"607\",                          \"value\": \"2\"                        },                        {                          \"group\": \"1\",                          \"id\": \"612\",                          \"value\": \"385-55\"                        },                        {                          \"group\": \"1\",                          \"id\": \"613\",                          \"value\": \"22,5\"                        },                        {                          \"group\": \"1\",                          \"id\": \"614\",                          \"value\": \"Measured\"                        },                        {                          \"group\": \"1\",                          \"id\": \"615\",                          \"value\": \"Y\"                        }                      ]                    }                  ]                }              ],              \"BillOfMaterial\": null,              \"description\": \"F1, D1, T1\"            }          ],          \"id\": \"001_8415E5D-47A2-4E79-BF1C-1F56B105AC6    _001\",          \"CIN\": \"178077\",          \"description\": \"Axle arrangement (1, 24)\",          \"OperationType\": \"AI\"        }      ],      \"id\": \"001_8415E5D-47A2-4E79-BF1C-1F56B105AC6\",      \"Name\": \"New ALF in TAS\"    }  ]}";
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


    @Test
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
        //Collection<ProcessStep> processStep = (Collection<ProcessStep>) new ProcessStep();
        WorkCellResource workCellResource = new WorkCellResource();
        workCellResource.setId("CTPP-01A");
        //workCellResource.setName( "omega" );
        processStep.setWorkCellResource(workCellResource);
        ArrayList<ProcessStep> processStepCollection = new ArrayList<>();
        processStepCollection.add(processStep);
        chassisDTO.setBillOfProcessSteps(processStepCollection);
        chassisDTOCollection.add(chassisDTO);
        try {
            ledgerClient.storeProcessStepRouting(chassisDTOCollection);
            Collection<ProcessStep> chassisDTOCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent(),
                    workCellResource.getId());
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
        processStepCollection.add(processStep);
        chassisDTO.setBillOfProcessSteps(processStepCollection);
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
        chassisDTO.setChassisId("A819631");
        chassisDTO.setComponent("CAB");
        chassisDTO.setSubComponent("TCAB");
        ProcessStep processStep = new ProcessStep();
        //Collection<ProcessStep> processStep = (Collection<ProcessStep>) new ProcessStep();
        WorkCellResource workCellResource = new WorkCellResource();
        workCellResource.setId("CTPP-01A");
        //workCellResource.setName( "omega" );
        processStep.setWorkCellResource(workCellResource);
        ArrayList<ProcessStep> processStepCollection = new ArrayList<>();
        processStepCollection.add(processStep);
        chassisDTO.setBillOfProcessSteps(processStepCollection);
        chassisDTOCollection.add(chassisDTO);
        //ledgerClient.storeProcessStepRouting(chassisDTOCollection);
        Collection<ProcessStep> chassisDTOCollection1 = null;
        try {
            chassisDTOCollection1 = ledgerClient.getProcessStep(chassisDTO.getChassisId(), chassisDTO.getComponent(), chassisDTO.getSubComponent(), workCellResource.getId());
        } catch (ProductUnitHubException e) {
            e.printStackTrace();
        }
        //assertEquals(chassisDTOCollection1, chassisDTOCollection);
        if (chassisDTOCollection1.isEmpty()) {
            System.out.println("Process step is empty!!!!");
        } else {
            System.out.println("Test getProcessStep OK!!!");
        }
        //assertFalse(e.getMessage(), true);
    }
}









