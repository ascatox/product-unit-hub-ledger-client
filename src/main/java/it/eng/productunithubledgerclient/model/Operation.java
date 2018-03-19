package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operation {
    private Integer sequenceNo;
    private List<InstructionText> instructionTexts;
    private String equipmentRequirements;
    private List<OperationStep> operationSteps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operation)) return false;
        Operation operation = (Operation) o;
        return Objects.equals( sequenceNo, operation.sequenceNo ) && Objects.equals( instructionTexts, operation.instructionTexts ) && Objects.equals( equipmentRequirements, operation.equipmentRequirements ) && Objects.equals( operationSteps, operation.operationSteps );
    }

    @Override
    public int hashCode() {

        return Objects.hash( sequenceNo, instructionTexts, equipmentRequirements, operationSteps );
    }

    public Operation(Integer sequenceNo, List<InstructionText> instructionTexts, String equipmentRequirements, List<OperationStep> operationSteps) {
        this.sequenceNo = sequenceNo;
        this.instructionTexts = new ArrayList<>();
        this.equipmentRequirements = equipmentRequirements;
        this.operationSteps = new ArrayList<>();
    }

    public Operation() {
        this.instructionTexts = new ArrayList<>();
        this.operationSteps = new ArrayList<>();
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public List<InstructionText> getInstructionTexts() {
        return instructionTexts;
    }

    public void setInstructionTexts(List<InstructionText> instructionTexts) {
        this.instructionTexts = instructionTexts;
    }

    public String getEquipmentRequirements() {
        return equipmentRequirements;
    }

    public void setEquipmentRequirements(String equipmentRequirements) {
        this.equipmentRequirements = equipmentRequirements;
    }

    public List<OperationStep> getOperationSteps() {
        return operationSteps;
    }

    public void setOperationSteps(List<OperationStep> operationSteps) {
        this.operationSteps = operationSteps;
    }
}

