package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a Result of an Operation.
 */
public class OperationResult {

    private Collection<OperationStepResult> operationStepResults;


    public OperationResult(Collection<OperationStepResult> operationStepResults) {
        this.operationStepResults = operationStepResults;
    }

    public OperationResult() {
        this.operationStepResults = new ArrayList<>();
    }

    /**
     * This field represents a collection of OperationStepResult {@link OperationStepResult}
     *
     * @return
     */

    public Collection<OperationStepResult> getOperationStepResults() {
        return operationStepResults;
    }

    public void setOperationStepResults(Collection<OperationStepResult> operationStepResults) {
        this.operationStepResults = operationStepResults;
    }
}
