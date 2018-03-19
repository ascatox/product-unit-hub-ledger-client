package it.eng.productunithubledgerclient.model;

import java.util.Objects;

public class EquipmentSpecification {

    public Integer sequenceNo;
    public String specification;
    public String value;
    public String quantity;

    public EquipmentSpecification(Integer sequenceNo, String specification, String value, String quantity) {
        this.sequenceNo = sequenceNo;
        this.specification = specification;
        this.value = value;
        this.quantity = quantity;
    }

    public EquipmentSpecification() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipmentSpecification)) return false;
        EquipmentSpecification that = (EquipmentSpecification) o;
        return Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( specification, that.specification ) && Objects.equals( value, that.value ) && Objects.equals( quantity, that.quantity );
    }

    @Override
    public int hashCode() {

        return Objects.hash( sequenceNo, specification, value, quantity );
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
