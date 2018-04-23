package it.eng.productunithubledgerclient.model;

import java.util.Objects;

/**
 * This class represents a result of an Operation Step.
 */
public class OperationStepResult {

    private Integer SequenceNo;
    private String StepName;
    private String StepStatus;
    private String ChannelId;
    private EquipmentResult EquipmentResult;
    private EquipmentRequirement EquipmentRequirement;


    public OperationStepResult(Integer sequenceNo, String stepName, String stepStatus, String channelId, EquipmentResult equipmentResult, EquipmentRequirement equipmentRequirement) {
        this.SequenceNo = sequenceNo;
        this.StepName = stepName;
        this.StepStatus = stepStatus;
        this.ChannelId = channelId;
        this.EquipmentResult = new EquipmentResult();
        this.EquipmentRequirement = new EquipmentRequirement();
    }

    public OperationStepResult() {
        this.EquipmentResult = new EquipmentResult();
        this.EquipmentRequirement = new EquipmentRequirement();
        this.SequenceNo = 0;
    }

    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.SequenceNo = sequenceNo;
    }

    public String getStepName() {
        return StepName;
    }

    public void setStepName(String stepName) {
        this.StepName = stepName;
    }

    public String getStepStatus() {
        return StepStatus;
    }

    public void setStepStatus(String stepStatus) {
        this.StepStatus = stepStatus;
    }

    public String getChannelId() {
        return ChannelId;
    }

    public void setChannelId(String channelId) {
        this.ChannelId = channelId;
    }

    public EquipmentResult getEquipmentResult() {
        return EquipmentResult;
    }

    public void setEquipmentResult(EquipmentResult equipmentResult) {
        this.EquipmentResult = equipmentResult;
    }

    public EquipmentRequirement getEquipmentRequirement() {
        return EquipmentRequirement;
    }

    public void setEquipmentRequirement(EquipmentRequirement equipmentRequirement) {
        this.EquipmentRequirement = equipmentRequirement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationStepResult)) return false;
        OperationStepResult that = (OperationStepResult) o;
        return Objects.equals( SequenceNo, that.SequenceNo ) && Objects.equals( StepName, that.StepName ) && Objects.equals( StepStatus, that.StepStatus ) && Objects.equals( ChannelId, that.ChannelId ) && Objects.equals( EquipmentResult, that.EquipmentResult ) && Objects.equals( EquipmentRequirement, that.EquipmentRequirement );
    }

    @Override
    public int hashCode() {

        return Objects.hash( SequenceNo, StepName, StepStatus, ChannelId, EquipmentResult, EquipmentRequirement );
    }
}
