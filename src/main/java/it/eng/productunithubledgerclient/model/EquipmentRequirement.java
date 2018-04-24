package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EquipmentRequirement {

    private String equipmentType;
    @NotNull
    private Integer sequenceNo;
    private Collection<EquipmentSpecification> specifications;

    public EquipmentRequirement(String equipmentType, Integer sequenceNo, Collection<EquipmentSpecification> specifications) {
        this.equipmentType = equipmentType;
        this.sequenceNo = sequenceNo;
        this.specifications = specifications;
    }

    public EquipmentRequirement() {
        this.specifications = new ArrayList<>();
        this.sequenceNo = 0;
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

    public Collection<EquipmentSpecification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<EquipmentSpecification> specifications) {
        this.specifications = specifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EquipmentRequirement that = (EquipmentRequirement) o;

        return sequenceNo != null ? sequenceNo.equals(that.sequenceNo) : that.sequenceNo == null;
    }

    @Override
    public int hashCode() {
        return sequenceNo != null ? sequenceNo.hashCode() : 0;
    }
}