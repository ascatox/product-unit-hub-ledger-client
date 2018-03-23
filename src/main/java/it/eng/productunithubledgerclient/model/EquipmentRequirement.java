package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipmentRequirement {


    private String equipmentType;
    private Integer sequenceNo;
    private List<EquipmentSpecification> specifications;

    public EquipmentRequirement() {
        this.specifications = new ArrayList<>();
    }

    public EquipmentRequirement(String equipmentType, Integer sequenceNo, List<EquipmentSpecification> specifications) {
        this.equipmentType = equipmentType;
        this.sequenceNo = sequenceNo;
        this.specifications = new ArrayList<>();
    }


    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public List<EquipmentSpecification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<EquipmentSpecification> specifications) {
        this.specifications = specifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipmentRequirement)) return false;
        EquipmentRequirement that = (EquipmentRequirement) o;
        return Objects.equals( equipmentType, that.equipmentType ) && Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( specifications, that.specifications );
    }

    @Override
    public int hashCode() {

        return Objects.hash( equipmentType, sequenceNo, specifications );
    }

}