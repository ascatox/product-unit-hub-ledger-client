package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents the result of a Process Step.<br/>
 * <b>This DTO shares data with the Chaincode</b>.
 */
public class ProcessStepResultDTO {
    @NotNull
    private String chassisId;
    @NotNull
    private String component;
    @NotNull
    private String subComponent;

    private String workCellResourceId;


    private Collection<OperationResult> operationResults;

    public ProcessStepResultDTO(@NotNull String chassisId, @NotNull String component, @NotNull String subComponent, String workCellResourceId) {
        this.chassisId = chassisId;
        this.component = component;
        this.subComponent = subComponent;
        this.workCellResourceId = workCellResourceId;
    }

    public ProcessStepResultDTO() {

        this.operationResults = new ArrayList<>(); //FIXME
    }

    public String getChassisId() {
        return chassisId;
    }

    public void setChassisId(String chassisId) {
        this.chassisId = chassisId;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getWorkCellResourceId() {
        return workCellResourceId;
    }

    public void setWorkCellResourceId(String workCellResourceId) {
        this.workCellResourceId = workCellResourceId;
    }

    public String getSubComponent() {
        return subComponent;
    }

    public void setSubComponent(String subComponent) {
        this.subComponent = subComponent;
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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ProcessStepResultDTO that = (ProcessStepResultDTO) o;

        if (chassisId != null ? !chassisId.equals(that.chassisId ) : that.chassisId != null)
            return false;
        if (component != null ? !component.equals(that.component ) : that.component != null)
            return false;
        if (subComponent != null ? !subComponent.equals(that.subComponent ) : that.subComponent != null)
            return false;
        return workCellResourceId != null ? workCellResourceId.equals(that.workCellResourceId ) : that.workCellResourceId == null;
    }

    @Override
    public int hashCode() {
        int result = chassisId != null ? chassisId.hashCode() : 0;
        result = 31 * result + (component != null ? component.hashCode() : 0);
        result = 31 * result + (subComponent != null ? subComponent.hashCode() : 0);
        result = 31 * result + (workCellResourceId != null ? workCellResourceId.hashCode() : 0);
        return result;
    }

}
