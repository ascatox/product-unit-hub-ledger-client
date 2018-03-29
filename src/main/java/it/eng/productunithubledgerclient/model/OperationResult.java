package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a Result of an Operation.
 */
public class OperationResult {

    private Collection<OperationResult> operationResults;


    public OperationResult(Collection<OperationResult> operationResults) {
        this.operationResults = new ArrayList<>();
    }

    public OperationResult() {
        this.operationResults = new ArrayList<>();
    }
    /**
     * This field represents a collection of OperationResult {@link OperationResult}
     * @return
     */
    public Collection<OperationResult> getOperationResults() {
        return operationResults;
    }

    public void setOperationResults(Collection<OperationResult> operationResults) {
        this.operationResults = operationResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationResult)) return false;
        OperationResult that = (OperationResult) o;
        return Objects.equals( operationResults, that.operationResults );
    }

    @Override
    public int hashCode() {

        return Objects.hash( operationResults );
    }
}
