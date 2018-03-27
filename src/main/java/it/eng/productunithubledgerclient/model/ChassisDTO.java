package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChassisDTO implements Serializable {


    @NotNull
    private String ChassisId;
    @NotNull
    private String Component;
    @NotNull
    private String SubComponent;

    private String productUnits;

    private List<ProcessStep> billOfProcessSteps;
    private List<ProcessStepResult> billOfProcessStepsResult;


    public ChassisDTO() {
        this.billOfProcessSteps = new ArrayList<>();
        this.billOfProcessStepsResult = new ArrayList<>();
    }

    public ChassisDTO(@NotNull String chassisId, @NotNull String component, @NotNull String subComponent, String productUnits, List<ProcessStep> billOfProcessSteps, List<ProcessStepResult> billOfProcessStepsResult) {
        ChassisId = chassisId;
        Component = component;
        SubComponent = subComponent;
        this.productUnits = productUnits;
        this.billOfProcessSteps = new ArrayList<>();
        this.billOfProcessStepsResult = new ArrayList<>();
    }

    public String getChassisId() {
        return ChassisId;
    }

    public void setChassisId(String chassisId) {
        ChassisId = chassisId;
    }

    public String getComponent() {
        return Component;
    }

    public void setComponent(String component) {
        Component = component;
    }

    public String getSubComponent() {
        return SubComponent;
    }

    public void setSubComponent(String subComponent) {
        SubComponent = subComponent;
    }

    public String getProductUnits() {
        return productUnits;
    }


    public void setProductUnits(String productUnits) {
        this.productUnits = productUnits;
    }

    public List<ProcessStep> getBillOfProcessSteps() {
        return billOfProcessSteps;
    }

    public void setBillOfProcessSteps(List<ProcessStep> billOfProcessSteps) {
        this.billOfProcessSteps = billOfProcessSteps;
    }

    public List<ProcessStepResult> getBillOfProcessStepsResult() {
        return billOfProcessStepsResult;
    }

    public void setBillOfProcessStepsResult(List<ProcessStepResult> billOfProcessStepsResult) {
        this.billOfProcessStepsResult = billOfProcessStepsResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ChassisDTO that = (ChassisDTO) o;

        if (ChassisId != null ? !ChassisId.equals(that.ChassisId) : that.ChassisId != null)
            return false;
        if (Component != null ? !Component.equals(that.Component) : that.Component != null)
            return false;
        return SubComponent != null ? SubComponent.equals(that.SubComponent) : that.SubComponent == null;
    }

    @Override
    public int hashCode() {
        int result = ChassisId != null ? ChassisId.hashCode() : 0;
        result = 31 * result + (Component != null ? Component.hashCode() : 0);
        result = 31 * result + (SubComponent != null ? SubComponent.hashCode() : 0);
        return result;
    }

}

