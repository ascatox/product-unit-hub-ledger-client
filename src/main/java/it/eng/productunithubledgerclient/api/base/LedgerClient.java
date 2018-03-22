package it.eng.productunithubledgerclient.api.base;

import it.eng.productunithubledgerclient.model.*;

import java.util.List;

public interface LedgerClient {

    //TODO I have to create a correct type of Exception for my managed Exceptions!!!
    /**
     *
     * @param chassisDTOS
     * @return
     * @throws Exception
     */
     void storeProcessStepRouting(List<ChassisDTO> chassisDTOS)  throws Exception;

    /**
     *
     * @param chassisDTO
     * @return
     * @throws Exception
     */
     void storeProcessStepResult(ChassisDTO chassisDTO) throws Exception;

    /**
     *
     * @param component,subComponent
     * @return
     * @throws Exception
     */

     List<ChassisDTO> getProcessStepRouting(String component, String subComponent)  throws Exception ;

    /**
     *
     * @param chassisID,component,subComponent
     * @return
     * @throws Exception
     */
     ChassisDTO getProcessStepResult(String chassisID, String component, String subComponent) throws Exception;

}
