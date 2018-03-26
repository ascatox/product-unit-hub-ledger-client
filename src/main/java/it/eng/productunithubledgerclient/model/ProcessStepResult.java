package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProcessStepResult {

    private List<OperationResult> operationResults;


    public ProcessStepResult(List<OperationResult> operationResults) {

        this.operationResults = new ArrayList<>();
    }

    public ProcessStepResult() {

        this.operationResults = new ArrayList<>();
    }

    public List<OperationResult> getOperationResults() {
        return operationResults;
    }

    public void setOperationResults(List<OperationResult> operationResults) {
        this.operationResults = operationResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessStepResult)) return false;
        ProcessStepResult that = (ProcessStepResult) o;
        return Objects.equals( operationResults, that.operationResults );
    }

    @Override
    public int hashCode() {

        return Objects.hash( operationResults );
    }

}
