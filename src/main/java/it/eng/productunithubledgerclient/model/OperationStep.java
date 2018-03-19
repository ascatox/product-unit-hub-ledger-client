package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OperationStep {

    private Integer sequenceNo;
    private String billofMaterial;
    private List <EquipmentRequirement> equipmentRequirements;
    private List <Part> parts;
    private List <InstructionText> istructionTexts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationStep)) return false;
        OperationStep that = (OperationStep) o;
        return Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( billofMaterial, that.billofMaterial ) && Objects.equals( equipmentRequirements, that.equipmentRequirements ) && Objects.equals( parts, that.parts ) && Objects.equals( istructionTexts, that.istructionTexts );
    }

    @Override
    public int hashCode() {

        return Objects.hash( sequenceNo, billofMaterial, equipmentRequirements, parts, istructionTexts );
    }

    public OperationStep(Integer sequenceNo, String billofMaterial, List<EquipmentRequirement> equipmentRequirements, List<Part> parts, List<InstructionText> istructionTexts) {
        this.sequenceNo = sequenceNo;
        this.billofMaterial = billofMaterial;
        this.equipmentRequirements = new ArrayList<>();
        this.parts = new ArrayList<>();
        this.istructionTexts = new ArrayList<>();
    }

    public OperationStep() {
        this.equipmentRequirements = new ArrayList<>();
        this.parts = new ArrayList<>();
        this.istructionTexts = new ArrayList<>();
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getBillofMaterial() {
        return billofMaterial;
    }

    public void setBillofMaterial(String billofMaterial) {
        this.billofMaterial = billofMaterial;
    }

    public List<EquipmentRequirement> getEquipmentRequirements() {
        return equipmentRequirements;
    }

    public void setEquipmentRequirements(List<EquipmentRequirement> equipmentRequirements) {
        this.equipmentRequirements = equipmentRequirements;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public List<InstructionText> getIstructionTexts() {
        return istructionTexts;
    }

    public void setIstructionTexts(List<InstructionText> istructionTexts) {
        this.istructionTexts = istructionTexts;
    }
}
