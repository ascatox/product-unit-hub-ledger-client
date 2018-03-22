package it.eng.productunithubledgerclient.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChassisDTO implements Serializable{



    private ChassisID chassisId;
    private String productUnits;
    private List<ProcessStep> billOfProcessStep;
    private List<ProcessStepResult> billOfProcessStepsResult;


    public ChassisDTO(ChassisID chassisId, String productUnits, List<ProcessStep> billOfProcessStep, List<ProcessStepResult> billOfProcessStepsResult) {
        this.chassisId = chassisId;
        this.productUnits = productUnits;
        this.billOfProcessStep = billOfProcessStep;
        this.billOfProcessStepsResult = billOfProcessStepsResult;
    }

    public ChassisDTO() {
        this.billOfProcessStep = new ArrayList<>();
        this.billOfProcessStepsResult = new ArrayList<>();
    }

    public ChassisID getChassisId() {
        return chassisId;
    }

    public void setChassisId(ChassisID chassisId) {
        this.chassisId = chassisId;
    }

    public String getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(String productUnits) {
        this.productUnits = productUnits;
    }

    public List<ProcessStep> getBillOfProcessStep() {
        return billOfProcessStep;
    }

    public void setBillOfProcessStep(List<ProcessStep> billOfProcessStep) {
        this.billOfProcessStep = billOfProcessStep;
    }

    public List<ProcessStepResult> getBillOfProcessStepsResult() {
        return billOfProcessStepsResult;
    }

    public void setBillOfProcessStepsResult(List<ProcessStepResult> billOfProcessStepsResult) {
        this.billOfProcessStepsResult = billOfProcessStepsResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChassisDTO)) return false;
        ChassisDTO that = (ChassisDTO) o;
        return Objects.equals( chassisId, that.chassisId  );
    }

    @Override
    public int hashCode() {

        return Objects.hash( chassisId );
    }
}
