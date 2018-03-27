package it.eng.productunithubledgerclient.api.base;

import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.api.helper.EventHandler;
import it.eng.productunithubledgerclient.model.*;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface LedgerClient {

    //TODO I have to create a correct type of Exception for my managed Exceptions!!!
    /**
     *
     * @param chassisDTOS
     * @return
     * @throws Exception
     */
     void storeProcessStepRouting(List<ChassisDTO> chassisDTOS) throws ProductUnitHubException, InterruptedException, ExecutionException, TimeoutException;

    /**
     *
     * @param chassisDTO
     * @return
     * @throws Exception
     */
     void storeProcessStepResult(ChassisDTO chassisDTO) throws ProductUnitHubException;

    /**
     *
     * @param json
     * @throws ProductUnitHubException
     */
    void storeProcessStepRouting(String json)  throws ProductUnitHubException;

    /**
     *
     * @param json
     * @throws ProductUnitHubException
     */
    void storeProcessStepResult(String json) throws ProductUnitHubException;

    /**
     *
     * @param component,subComponent
     * @return
     * @throws Exception
     */

     List<ChassisDTO> getProcessStepRouting(String component, String subComponent)  throws ProductUnitHubException ;

    /**
     *
     * @param chassisID,component,subComponent
     * @return
     * @throws Exception
     */
     ChassisDTO getProcessStepResult(String chassisID, String component, String subComponent) throws ProductUnitHubException;



}
