package it.eng.productunithubledgerclient.base;

import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.model.ChassisDTO;
import it.eng.productunithubledgerclient.model.ProcessStep;
import it.eng.productunithubledgerclient.model.ProcessStepResultDTO;

import java.util.Collection;

public interface LedgerClient {

    /**
     * This method stores in the Ledger a ProcessStepRouting consisting in a collection of Chassis {@link ChassisDTO}.
     *
     * @param chassisDTOs the list of Chassis
     * @throws ProductUnitHubException
     * @see ChassisDTO
     */
    void storeProcessStepRouting(Collection<ChassisDTO> chassisDTOs) throws ProductUnitHubException;

    /**
     * This method stores in the Ledger a ProcessStepResultDTO {@link ProcessStepResultDTO}
     *
     * @param processStepResultDTO
     * @return
     * @throws Exception
     * @see ProcessStepResultDTO
     */
    void storeProcessStepResult(ProcessStepResultDTO processStepResultDTO) throws ProductUnitHubException;

    /**
     * This method stores in the Ledger a ProcessStepRouting consisting in a collection of Chassis given in json format {@link ChassisDTO}
     *
     * @param json
     * @throws ProductUnitHubException
     * @see ChassisDTO
     */
    void storeProcessStepRouting(String json) throws ProductUnitHubException;

    /**
     * This method stores in the Ledger a ProcessStepResultDTO given in json format {@link ProcessStepResultDTO}
     *
     * @param json
     * @throws ProductUnitHubException
     * @see ProcessStepResultDTO
     */
    void storeProcessStepResult(String json) throws ProductUnitHubException;

    /**
     * This method gives a collection of Chassis {@link ChassisDTO}
     *
     * @param component
     * @param subComponent
     * @return
     * @throws ProductUnitHubException
     * @see ChassisDTO
     */
    Collection<ChassisDTO> getProcessStepRouting(String component, String subComponent) throws ProductUnitHubException;


    /**
     * This method gives a Chassis {@link ChassisDTO}
     *
     * @param chassisId
     * @param component
     * @param subComponent
     * @return
     * @throws ProductUnitHubException
     * @see ChassisDTO
     */
    ChassisDTO getProcessStepRouting(String chassisId, String component, String subComponent) throws ProductUnitHubException;


    /**
     * This method gives a collection of ProcessStep {@link ProcessStep}
     *
     * @param chassisId
     * @param component
     * @param subComponent
     * @param workCellResourceId
     * @return
     * @throws ProductUnitHubException
     * @see ProcessStep
     */
    Collection<ProcessStep> getProcessStep(String chassisId, String component, String subComponent, String workCellResourceId) throws ProductUnitHubException;

    /**
     * This method gives a collection of ProcessStep {@link ProcessStep}
     *
     * @param chassisId
     * @param component
     * @param subComponent
     * @return
     * @throws ProductUnitHubException
     */
    Collection<ProcessStep> getProcessStep(String chassisId, String component, String subComponent) throws ProductUnitHubException;


    /**
     * This method gives a ProcessStepResultDTO {@link ProcessStepResultDTO} passing as parameters a full key with component, subComponent and WorkCellResourceId
     *
     * @param chassisId
     * @param component
     * @param subComponent
     * @param workCellResourceId
     * @return
     * @throws ProductUnitHubException
     * @see ProcessStepResultDTO
     */

    ProcessStepResultDTO getProcessStepResult(String chassisId, String component, String subComponent, String workCellResourceId) throws ProductUnitHubException;

}
