package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipmentSpecification {
    @NotNull
    public Integer sequenceNo;
    public String specification;
    public String value;
    public Integer quantity;
    public List<Parameters> Parameters;


    public EquipmentSpecification() {
        this.Parameters = new ArrayList<>(  );

    }

    public EquipmentSpecification(@NotNull Integer sequenceNo, String specification, String value, Integer quantity, List<it.eng.productunithubledgerclient.model.Parameters> parameters) {
        this.sequenceNo = sequenceNo;
        this.specification = specification;
        this.value = value;
        this.quantity = quantity;
        this.Parameters = new ArrayList<>(  );
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<it.eng.productunithubledgerclient.model.Parameters> getParameters() {
        return Parameters;
    }

    public void setParameters(List<it.eng.productunithubledgerclient.model.Parameters> parameters) {
        Parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipmentSpecification)) return false;
        EquipmentSpecification that = (EquipmentSpecification) o;
        return Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( specification, that.specification ) && Objects.equals( value, that.value ) && Objects.equals( quantity, that.quantity ) && Objects.equals( Parameters, that.Parameters );
    }

    @Override
    public int hashCode() {

        return Objects.hash( sequenceNo, specification, value, quantity, Parameters );
    }
}
