package it.eng.productunithubledgerclient.api.base;

import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.api.helper.EventHandler;
import it.eng.productunithubledgerclient.model.*;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface LedgerClient {

    /**
     *
     * @param chassisDTOs
     * @throws ProductUnitHubException
     */
    void storeProcessStepRouting(Iterator<ChassisDTO> chassisDTOs) throws ProductUnitHubException;

    /**
     * @param processStepResult
     * @return
     * @throws Exception
     */
    void storeProcessStepResult(ProcessStepResult processStepResult) throws ProductUnitHubException;

    /**
     * @param json
     * @throws ProductUnitHubException
     */
    void storeProcessStepRouting(String json) throws ProductUnitHubException;

    /**
     * @param json
     * @throws ProductUnitHubException
     */
    void storeProcessStepResult(String json) throws ProductUnitHubException;

    /**
     *
     * @param component
     * @param subComponent
     * @return
     * @throws ProductUnitHubException
     */
    Iterator<ChassisDTO> getProcessStepRouting(String component, String subComponent) throws ProductUnitHubException;


    /**
     *
     * @param chassisID
     * @param component
     * @param subComponent
     * @return
     * @throws ProductUnitHubException
     */
    ChassisDTO getProcessStepRouting(String chassisID, String component, String subComponent) throws ProductUnitHubException;


    /**
     * @param chassisID
     * @param component
     * @param subComponent
     * @param workCellResourceID
     * @return
     * @throws ProductUnitHubException
     */
    Iterator<ProcessStep> getProcessStep(String chassisID, String component, String subComponent, String workCellResourceID) throws ProductUnitHubException;

    /**
     * @param chassisID
     * @param component
     * @param subComponent
     * @param workCellResourceID
     * @return
     * @throws ProductUnitHubException
     */

    ProcessStepResult getProcessStepResult(String chassisID, String component, String subComponent, String workCellResourceID) throws ProductUnitHubException;

}
