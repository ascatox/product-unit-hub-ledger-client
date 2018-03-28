package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * This class represents an Operation to execute.
 */
public class OperationStep {

    @NotNull
    private Integer sequenceNo;
    private String Description;

    private Collection<Material> billofMaterial;
    private Collection <EquipmentRequirement> equipmentRequirements;
    private Collection <InstructionText> istructionTexts;


    public OperationStep(Integer sequenceNo, String billofMaterial,String Description, List<EquipmentRequirement> equipmentRequirements, List<InstructionText> istructionTexts) {
        this.sequenceNo = sequenceNo;
        this.billofMaterial = new ArrayList<>();
        this.equipmentRequirements = new ArrayList<>();
        this.istructionTexts = new ArrayList<>();
        this.Description = Description;
    }

    public OperationStep() {
        this.equipmentRequirements = new ArrayList<>();
        this.istructionTexts = new ArrayList<>();
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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setBillofMaterial(List<Material> billofMaterial) {
        this.billofMaterial = billofMaterial;
    }


    /**
     * The field represents a collection of EquipmentRequirements {@link EquipmentRequirement}
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
    public Collection<InstructionText> getIstructionTexts() {
        return istructionTexts;
    }

    public void setIstructionTexts(List<InstructionText> istructionTexts) {
        this.istructionTexts = istructionTexts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OperationStep that = (OperationStep) o;

        return sequenceNo != null ? sequenceNo.equals(that.sequenceNo) : that.sequenceNo == null;
    }

    @Override
    public int hashCode() {
        return sequenceNo != null ? sequenceNo.hashCode() : 0;
    }
}
