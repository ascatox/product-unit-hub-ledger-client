package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a Result of an Operation.
 */
public class OperationResult {

    private Collection<OperationStepResult> OperationStepResults;


    public OperationResult(Collection<OperationStepResult> operationStepResults) {
        this.OperationStepResults = new ArrayList<>();
    }

    public OperationResult() {
        this.OperationStepResults = new ArrayList<>();
    }

    /**
     * This field represents a collection of OperationStepResult {@link OperationStepResult}
     *
     * @return
     */

    public Collection<OperationStepResult> getOperationStepResults() {
        return OperationStepResults;
    }

    public void setOperationStepResults(Collection<OperationStepResult> operationStepResults) {
        this.OperationStepResults = operationStepResults;
    }
}
