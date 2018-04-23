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
    private Integer SequenceNo;
    private String Description;

    private Collection<Material> BillofMaterial;
    private Collection <EquipmentRequirement> EquipmentRequirements;
    private Collection <InstructionText> IstructionTexts;


    public OperationStep(Integer sequenceNo, String billofMaterial, String Description, Collection<EquipmentRequirement> equipmentRequirements, Collection<InstructionText> istructionTexts) {
        this.SequenceNo = sequenceNo;
        this.BillofMaterial = new ArrayList<>();
        this.EquipmentRequirements = new ArrayList<>();
        this.IstructionTexts = new ArrayList<>();
        this.Description = Description;
    }

    public OperationStep() {
        this.EquipmentRequirements = new ArrayList<>();
        this.IstructionTexts = new ArrayList<>();
        this.SequenceNo = 0;
    }

    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.SequenceNo = sequenceNo;
    }

    /**
     * This field represents a collection of materials needed {@link Material}.
     * @return
     */
    public Collection<Material> getBillofMaterial() {
        return BillofMaterial;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setBillofMaterial(List<Material> billofMaterial) {
        this.BillofMaterial = billofMaterial;
    }


    /**
     * The field represents a collection of EquipmentRequirements {@link EquipmentRequirement}
     * @return
     */
    public Collection<EquipmentRequirement> getEquipmentRequirements() {
        return EquipmentRequirements;
    }

    public void setEquipmentRequirements(List<EquipmentRequirement> equipmentRequirements) {
        this.EquipmentRequirements = equipmentRequirements;
    }


    /**
     * The field represents a collection of Instructions to execute {@link InstructionText}.
     * @return
     */
    public Collection<InstructionText> getIstructionTexts() {
        return IstructionTexts;
    }

    public void setIstructionTexts(List<InstructionText> istructionTexts) {
        this.IstructionTexts = istructionTexts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OperationStep that = (OperationStep) o;

        return SequenceNo != null ? SequenceNo.equals(that.SequenceNo ) : that.SequenceNo == null;
    }

    @Override
    public int hashCode() {
        return SequenceNo != null ? SequenceNo.hashCode() : 0;
    }
}
