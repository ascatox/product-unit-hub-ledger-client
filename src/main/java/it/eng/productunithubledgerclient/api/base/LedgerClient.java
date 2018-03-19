package it.eng.productunithubledgerclient.api.base;

import it.eng.productunithubledgerclient.model.*;

import java.util.List;

public interface LedgerClient {

    //TODO I have to create a correct type of Exception for my managed Exceptions!!!
    /**
     *
     * @param processStepResult
     * @return
     * @throws Exception
     */
    ProcessStepResult storeProcessStepResult(ProcessStepResult processStepResult ) throws Exception;

    /**
     *
     * @param operationResult
     * @return
     * @throws Exception
     */
    OperationResult storeOperationResult(OperationResult operationResult) throws Exception;

    /**
     *
     * @param operation
     * @return
     * @throws Exception
     */

     List<OperationStep> retrieveOperation(Operation operation) throws Exception ;

    /**
     *
     * @param operationResult
     * @return
     * @throws Exception
     */
     List<OperationStepResult> retrieveOperationResult (OperationResult operationResult) throws Exception;

}
