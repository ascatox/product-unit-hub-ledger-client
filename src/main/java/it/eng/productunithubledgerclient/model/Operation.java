package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operation {
    @NotNull
    private Integer sequenceNo;

    private List<InstructionText> instructionTexts;

    private List<EquipmentRequirement> equipmentRequirements;

    private List<OperationStep> operationSteps;

    private String Id;

    @Pattern( regexp = "[0-9]")
    private String CIN;

    private String Description;
    private String OperationType;


    public Operation() {
        this.instructionTexts = new ArrayList<>(  );
        this.equipmentRequirements = new ArrayList<>(  );
        this.operationSteps = new ArrayList<>(  );
    }

    public Operation(@NotNull Integer sequenceNo, List<InstructionText> instructionTexts, List<EquipmentRequirement> equipmentRequirements, List<OperationStep> operationSteps, String id, @Pattern(regexp = "[0-9]") String CIN, String description, String operationType) {
        this.sequenceNo = sequenceNo;
        this.instructionTexts = new ArrayList<>(  );
        this.equipmentRequirements = new ArrayList<>(  );
        this.operationSteps = new ArrayList<>(  );
        Id = id;
        this.CIN = CIN;
        Description = description;
        OperationType = operationType;
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

    public List<EquipmentRequirement> getEquipmentRequirements() {
        return equipmentRequirements;
    }

    public void setEquipmentRequirements(List<EquipmentRequirement> equipmentRequirements) {
        this.equipmentRequirements = equipmentRequirements;
    }

    public List<OperationStep> getOperationSteps() {
        return operationSteps;
    }

    public void setOperationSteps(List<OperationStep> operationSteps) {
        this.operationSteps = operationSteps;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
        Description = description;
    }

    public String getOperationType() {
        return OperationType;
    }

    public void setOperationType(String operationType) {
        OperationType = operationType;
    }

    @Override
    public int hashCode() {

        return Objects.hash( sequenceNo, instructionTexts, equipmentRequirements, operationSteps );
    }
}

