package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OperationResult {

    private List<OperationResult> operationResults;

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

    public OperationResult(List<OperationResult> operationResults) {
        this.operationResults = new ArrayList<>();
    }

    public OperationResult() {

        this.operationResults = new ArrayList<>();
    }

    public List<OperationResult> getOperationResults() {
        return operationResults;
    }

    public void setOperationResults(List<OperationResult> operationResults) {
        this.operationResults = operationResults;
    }
}
