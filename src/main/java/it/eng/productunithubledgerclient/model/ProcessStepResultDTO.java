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
    private String ChassisId;
    @NotNull
    private String Component;
    @NotNull
    private String SubComponent;

    private String WorkCellResourceId;


    private Collection<OperationResult> operationResults;

    public ProcessStepResultDTO(@NotNull String chassisId, @NotNull String component, @NotNull String subComponent, String workCellResourceId) {
        this.ChassisId = chassisId;
        this.Component = component;
        this.SubComponent = subComponent;
        this.WorkCellResourceId = workCellResourceId;
    }

    public ProcessStepResultDTO() {

        this.operationResults = new ArrayList<>(); //FIXME
    }

    public String getChassisId() {
        return ChassisId;
    }

    public void setChassisId(String chassisId) {
        this.ChassisId = chassisId;
    }

    public String getComponent() {
        return Component;
    }

    public void setComponent(String component) {
        this.Component = component;
    }

    public String getWorkCellResourceId() {
        return WorkCellResourceId;
    }

    public void setWorkCellResourceId(String workCellResourceId) {
        this.WorkCellResourceId = workCellResourceId;
    }

    public String getSubComponent() {
        return SubComponent;
    }

    public void setSubComponent(String subComponent) {
        this.SubComponent = subComponent;
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

        if (ChassisId != null ? !ChassisId.equals(that.ChassisId ) : that.ChassisId != null)
            return false;
        if (Component != null ? !Component.equals(that.Component ) : that.Component != null)
            return false;
        if (SubComponent != null ? !SubComponent.equals(that.SubComponent ) : that.SubComponent != null)
            return false;
        return WorkCellResourceId != null ? WorkCellResourceId.equals(that.WorkCellResourceId ) : that.WorkCellResourceId == null;
    }

    @Override
    public int hashCode() {
        int result = ChassisId != null ? ChassisId.hashCode() : 0;
        result = 31 * result + (Component != null ? Component.hashCode() : 0);
        result = 31 * result + (SubComponent != null ? SubComponent.hashCode() : 0);
        result = 31 * result + (WorkCellResourceId != null ? WorkCellResourceId.hashCode() : 0);
        return result;
    }

}
