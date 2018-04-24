package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class represents an Operation Step to execute.
 */
public class OperationStep {

    @NotNull
    private Integer sequenceNo;
    private String description;

    private Collection<Material> billofMaterial;
    private Collection <EquipmentRequirement> equipmentRequirements;
    private Collection <InstructionText> instructionTexts;


    public OperationStep(Integer sequenceNo, Collection<Material> billofMaterial, String Description, Collection<EquipmentRequirement> equipmentRequirements, Collection<InstructionText> instructionTexts) {
        this.sequenceNo = sequenceNo;
        this.billofMaterial = billofMaterial;
        this.equipmentRequirements = equipmentRequirements;
        this.instructionTexts = instructionTexts;
        this.description = Description;
    }

    public OperationStep() {
        this.equipmentRequirements = new ArrayList<>();
        this.instructionTexts = new ArrayList<>();
        this.sequenceNo = 0;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    /**
     * This field represents a collection of materials needed {@link Material}.
     * @return
     */
    public Collection<Material> getBillofMaterial() {
        return billofMaterial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBillofMaterial(List<Material> billofMaterial) {
        this.billofMaterial = billofMaterial;
    }


    /**
     * The field represents a collection of equipmentRequirements {@link EquipmentRequirement}
     * @return
     */
    public Collection<EquipmentRequirement> getEquipmentRequirements() {
        return equipmentRequirements;
    }

    public void setEquipmentRequirements(List<EquipmentRequirement> equipmentRequirements) {
        this.equipmentRequirements = equipmentRequirements;
    }


    /**
     * The field represents a collection of Instructions to execute {@link InstructionText}.
     * @return
     */
    public Collection<InstructionText> getInstructionTexts() {
        return instructionTexts;
    }

    public void setInstructionTexts(List<InstructionText> instructionTexts) {
        this.instructionTexts = instructionTexts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OperationStep that = (OperationStep) o;

        return sequenceNo != null ? sequenceNo.equals(that.sequenceNo ) : that.sequenceNo == null;
    }

    @Override
    public int hashCode() {
        return sequenceNo != null ? sequenceNo.hashCode() : 0;
    }
}
