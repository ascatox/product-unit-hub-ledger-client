package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Operation {
    @NotNull
    private Integer SequenceNo;
    private String Id;
    @Pattern( regexp = "[0-9]")
    private String CIN;
    private String Description;
    private String OperationType;

    private Collection<InstructionText> InstructionTexts;
    private Collection<EquipmentRequirement> EquipmentRequirements;
    private Collection<OperationStep> OperationSteps;


    public Operation() {
        this.InstructionTexts = new ArrayList<>(  );
        this.EquipmentRequirements = new ArrayList<>(  );
        this.OperationSteps = new ArrayList<>(  );
        this.SequenceNo = 0;
    }

    public Operation(@NotNull Integer sequenceNo, Collection<InstructionText> instructionTexts, Collection<EquipmentRequirement> equipmentRequirements, Collection<OperationStep> operationSteps, String id, @Pattern(regexp = "[0-9]") String CIN, String description, String operationType) {
        this.SequenceNo = sequenceNo;
        this.InstructionTexts = new ArrayList<>(  );
        this.EquipmentRequirements = new ArrayList<>(  );
        this.OperationSteps = new ArrayList<>(  );
        this.Id = id;
        this.CIN = CIN;
        this.Description = description;
        this.OperationType = operationType;
    }

    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.SequenceNo = sequenceNo;
    }

    public Collection<InstructionText> getInstructionTexts() {
        return InstructionTexts;
    }

    public void setInstructionTexts(List<InstructionText> instructionTexts) {
        this.InstructionTexts = instructionTexts;
    }

    public Collection<EquipmentRequirement> getEquipmentRequirements() {
        return EquipmentRequirements;
    }

    public void setEquipmentRequirements(List<EquipmentRequirement> equipmentRequirements) {
        this.EquipmentRequirements = equipmentRequirements;
    }

    public Collection<OperationStep> getOperationSteps() {
        return OperationSteps;
    }

    public void setOperationSteps(List<OperationStep> operationSteps) {
        this.OperationSteps = operationSteps;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getOperationType() {
        return OperationType;
    }

    public void setOperationType(String operationType) {
        this.OperationType = operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Operation operation = (Operation) o;

        if (SequenceNo != null ? !SequenceNo.equals(operation.SequenceNo ) : operation.SequenceNo != null)
            return false;
        return Id != null ? Id.equals(operation.Id ) : operation.Id == null;
    }

    @Override
    public int hashCode() {
        int result = SequenceNo != null ? SequenceNo.hashCode() : 0;
        result = 31 * result + (Id != null ? Id.hashCode() : 0);
        return result;
    }
}

