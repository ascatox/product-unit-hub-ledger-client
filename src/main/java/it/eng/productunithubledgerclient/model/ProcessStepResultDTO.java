package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * This class represents the result of a Process Step.<br/>
 * <b>This DTO shares data with the Chaincode</b>.
 */
public class ProcessStepResultDTO {

    private Collection<OperationResult> operationResults;


    public ProcessStepResultDTO(Collection<OperationResult> operationResults) {

        this.operationResults = new ArrayList<>(); //FIXME
    }

    public ProcessStepResultDTO() {

        this.operationResults = new ArrayList<>(); //FIXME
    }

    /**
     * The field contains a collection of operation results {@link OperationResult}.
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
        if (!(o instanceof ProcessStepResultDTO)) return false;
        ProcessStepResultDTO that = (ProcessStepResultDTO) o;
        return Objects.equals( operationResults, that.operationResults );
    }

    @Override
    public int hashCode() {

        return Objects.hash( operationResults );
    }

}
