package it.eng.productunithubledgerclient.model;

import java.util.Objects;

/**
 * This class represents a result of an Operation Step.
 */
public class OperationStepResult {

    private Integer sequenceNo;
    private String stepName;
    private String stepStatus;
    private String channelId;
    private EquipmentResult equipmentResult;
    private EquipmentRequirement equipmentRequirement;


    public OperationStepResult(Integer sequenceNo, String stepName, String stepStatus, String channelId, EquipmentResult equipmentResult, EquipmentRequirement equipmentRequirement) {
        this.sequenceNo = sequenceNo;
        this.stepName = stepName;
        this.stepStatus = stepStatus;
        this.channelId = channelId;
        this.equipmentResult =  equipmentResult;
        this.equipmentRequirement = equipmentRequirement;
    }

    public OperationStepResult() {
        this.equipmentResult = new EquipmentResult();
        this.equipmentRequirement = new EquipmentRequirement();
        this.sequenceNo = 0;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getStepStatus() {
        return stepStatus;
    }

    public void setStepStatus(String stepStatus) {
        this.stepStatus = stepStatus;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public EquipmentResult getEquipmentResult() {
        return equipmentResult;
    }

    public void setEquipmentResult(EquipmentResult equipmentResult) {
        this.equipmentResult = equipmentResult;
    }

    public EquipmentRequirement getEquipmentRequirement() {
        return equipmentRequirement;
    }

    public void setEquipmentRequirement(EquipmentRequirement equipmentRequirement) {
        this.equipmentRequirement = equipmentRequirement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationStepResult)) return false;
        OperationStepResult that = (OperationStepResult) o;
        return Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( stepName, that.stepName ) && Objects.equals( stepStatus, that.stepStatus ) && Objects.equals( channelId, that.channelId ) && Objects.equals( equipmentResult, that.equipmentResult ) && Objects.equals( equipmentRequirement, that.equipmentRequirement );
    }

    @Override
    public int hashCode() {

        return Objects.hash( sequenceNo, stepName, stepStatus, channelId, equipmentResult, equipmentRequirement );
    }
}
