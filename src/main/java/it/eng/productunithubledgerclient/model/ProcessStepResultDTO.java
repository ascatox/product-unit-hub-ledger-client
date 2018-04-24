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

    private String workcellResourceId;


    private Collection<OperationResult> operationResults;

    public ProcessStepResultDTO(@NotNull String chassisId, @NotNull String component, @NotNull String subComponent, String workcellResourceId) {
        this.chassisId = chassisId;
        this.component = component;
        this.subComponent = subComponent;
        this.workcellResourceId = workcellResourceId;
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

    public String getWorkcellResourceId() {
        return workcellResourceId;
    }

    public void setWorkcellResourceId(String workcellResourceId) {
        this.workcellResourceId = workcellResourceId;
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
        return workcellResourceId != null ? workcellResourceId.equals(that.workcellResourceId) : that.workcellResourceId == null;
    }

    @Override
    public int hashCode() {
        int result = chassisId != null ? chassisId.hashCode() : 0;
        result = 31 * result + (component != null ? component.hashCode() : 0);
        result = 31 * result + (subComponent != null ? subComponent.hashCode() : 0);
        result = 31 * result + (workcellResourceId != null ? workcellResourceId.hashCode() : 0);
        return result;
    }

}
