package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EquipmentRequirement {

    private String EquipmentType;
    @NotNull
    private Integer SequenceNo;
    private Collection<EquipmentSpecification> Specifications;

    public EquipmentRequirement(String equipmentType, Integer sequenceNo, Collection<EquipmentSpecification> specifications) {
        this.EquipmentType = equipmentType;
        this.SequenceNo = sequenceNo;
        this.Specifications = new ArrayList<>();
    }

    public EquipmentRequirement() {
        this.Specifications = new ArrayList<>();
        this.SequenceNo = 0;
    }

    public String getEquipmentType() {
        return EquipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.EquipmentType = equipmentType;
    }

    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.SequenceNo = sequenceNo;
    }

    public Collection<EquipmentSpecification> getSpecifications() {
        return Specifications;
    }

    public void setSpecifications(List<EquipmentSpecification> specifications) {
        this.Specifications = specifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EquipmentRequirement that = (EquipmentRequirement) o;

        return SequenceNo != null ? SequenceNo.equals(that.SequenceNo ) : that.SequenceNo == null;
    }

    @Override
    public int hashCode() {
        return SequenceNo != null ? SequenceNo.hashCode() : 0;
    }
}