package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OperationStep {

    @NotNull
    private Integer sequenceNo;
    private String Description;

    private List<Material> billofMaterial;
    private List <EquipmentRequirement> equipmentRequirements;
    private List <InstructionText> istructionTexts;


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

    public List<Material> getBillofMaterial() {
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

    public List<EquipmentRequirement> getEquipmentRequirements() {
        return equipmentRequirements;
    }

    public void setEquipmentRequirements(List<EquipmentRequirement> equipmentRequirements) {
        this.equipmentRequirements = equipmentRequirements;
    }



    public List<InstructionText> getIstructionTexts() {
        return istructionTexts;
    }

    public void setIstructionTexts(List<InstructionText> istructionTexts) {
        this.istructionTexts = istructionTexts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationStep)) return false;
        OperationStep that = (OperationStep) o;
        return Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( billofMaterial, that.billofMaterial ) && Objects.equals( equipmentRequirements, that.equipmentRequirements ) && Objects.equals( istructionTexts, that.istructionTexts );
    }

    @Override
    public int hashCode() {

        return Objects.hash( sequenceNo, billofMaterial, equipmentRequirements, istructionTexts );
    }
}
