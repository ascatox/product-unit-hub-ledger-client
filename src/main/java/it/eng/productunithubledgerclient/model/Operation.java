package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Operation {
    @NotNull
    private Integer sequenceNo;
    private String id;
    @Pattern(regexp = "[0-9]")
    private String cin;
    private String description;
    private String operationType;

    private Collection<InstructionText> instructionTexts;
    private Collection<EquipmentRequirement> equipmentRequirements;
    private Collection<OperationStep> operationSteps;


    public Operation() {
        this.instructionTexts = new ArrayList<>();
        this.equipmentRequirements = new ArrayList<>();
        this.operationSteps = new ArrayList<>();
        this.sequenceNo = 0;
    }

    public Operation(@NotNull Integer sequenceNo, Collection<InstructionText> instructionTexts, Collection<EquipmentRequirement> equipmentRequirements, Collection<OperationStep> operationSteps, String id, @Pattern(regexp = "[0-9]") String cin, String description, String operationType) {
        this.sequenceNo = sequenceNo;
        this.instructionTexts = instructionTexts;
        this.equipmentRequirements = equipmentRequirements;
        this.operationSteps = operationSteps;
        this.id = id;
        this.cin = cin;
        this.description = description;
        this.operationType = operationType;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Collection<InstructionText> getInstructionTexts() {
        return instructionTexts;
    }

    public void setInstructionTexts(List<InstructionText> instructionTexts) {
        this.instructionTexts = instructionTexts;
    }

    public Collection<EquipmentRequirement> getEquipmentRequirements() {
        return equipmentRequirements;
    }

    public void setEquipmentRequirements(List<EquipmentRequirement> equipmentRequirements) {
        this.equipmentRequirements = equipmentRequirements;
    }

    public Collection<OperationStep> getOperationSteps() {
        return operationSteps;
    }

    public void setOperationSteps(List<OperationStep> operationSteps) {
        this.operationSteps = operationSteps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Operation operation = (Operation) o;

        if (sequenceNo != null ? !sequenceNo.equals(operation.sequenceNo) : operation.sequenceNo != null)
            return false;
        return id != null ? id.equals(operation.id) : operation.id == null;
    }

    @Override
    public int hashCode() {
        int result = sequenceNo != null ? sequenceNo.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}

