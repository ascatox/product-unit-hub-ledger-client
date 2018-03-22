package it.eng.productunithubledgerclient.api;

import it.eng.productunithubledgerclient.api.config.ConfigManager;
import it.eng.productunithubledgerclient.model.*;

import java.util.List;

final public class LedgerClient implements it.eng.productunithubledgerclient.api.base.LedgerClient {

    private ConfigManager configManager;


    @Override
    public ProcessStepResult storeProcessStepResult(ProcessStepResult processStepResult) throws Exception {
        return null;
    }

    @Override
    public OperationResult storeOperationResult(OperationResult operationResult) throws Exception {
        return null;
    }

    @Override
    public List<OperationStep> retrieveOperation(Operation operation) throws Exception {
        return null;
    }

    @Override
    public List<OperationStepResult> retrieveOperationResult(OperationResult operationResult) throws Exception {
        return null;
    }
}