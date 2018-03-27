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
     * This method store in the Ledger a ProcessStepRouting consisting in a list of Chassis {@link ChassisDTO}.
     * @see ChassisDTO
     * @param chassisDTOs the list of Chassis
     * @throws ProductUnitHubException
     */
    void storeProcessStepRouting(final List<ChassisDTO> chassisDTOs) throws ProductUnitHubException;

    /**
     * This method store in the Ledger a ProcessStepResult {@link ProcessStepResult}
     * @see ProcessStepResult
     * @param processStepResult
     * @return
     * @throws Exception
     */
    void storeProcessStepResult(final ProcessStepResult processStepResult) throws ProductUnitHubException;

    /**
     * This method store in the Ledger a ProcessStepRouting consisting in a list of Chassis given in json format {@link ChassisDTO}
     * @see ChassisDTO
     * @param json
     * @throws ProductUnitHubException
     */
    void storeProcessStepRouting(final String json) throws ProductUnitHubException;

    /**
     * This method store in the Ledger a ProcessStepResult given in json format {@link ProcessStepResult}
     * @see ProcessStepResult
     * @param json
     * @throws ProductUnitHubException
     */
    void storeProcessStepResult(final String json) throws ProductUnitHubException;

    /**
     * This method gives a list of Chassis {@link ChassisDTO}
     * @see ChassisDTO
     * @param component
     * @param subComponent
     * @return
     * @throws ProductUnitHubException
     */
    List<ChassisDTO> getProcessStepRouting(final String component, final String subComponent) throws ProductUnitHubException;


    /**
     * This method gives a Chassis {@link ChassisDTO}
     * @see ChassisDTO
     * @param chassisID
     * @param component
     * @param subComponent
     * @return
     * @throws ProductUnitHubException
     */
    ChassisDTO getProcessStepRouting(final String chassisID, final String component, final String subComponent) throws ProductUnitHubException;


    /**
     * This method gives a list of ProcessStep {@link ProcessStep}
     * @see ProcessStep
     * @param chassisID
     * @param component
     * @param subComponent
     * @param workCellResourceID
     * @return
     * @throws ProductUnitHubException
     */
    List<ProcessStep> getProcessStep(final String chassisID, final String component, final String subComponent, final String workCellResourceID) throws ProductUnitHubException;

    /**
     *
     * @param chassisID
     * @param component
     * @param subComponent
     * @param workCellResourceID
     * @return
     * @throws ProductUnitHubException
     */

    ProcessStepResult getProcessStepResult(final String chassisID, final String component, final String subComponent, final String workCellResourceID) throws ProductUnitHubException;

}
