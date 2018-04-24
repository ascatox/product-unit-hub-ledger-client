package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EquipmentSpecification {
    @NotNull
    public Integer sequenceNo;
    public String specification;
    public String value;
    public Integer quantity;
    public Collection<Parameters> parameters;


    public EquipmentSpecification() {
        this.parameters = new ArrayList<>(  );
        this.sequenceNo = 0;

    }

    public EquipmentSpecification(@NotNull Integer sequenceNo, String specification, String value, Integer quantity, Collection<Parameters> parameters) {
        this.sequenceNo = sequenceNo;
        this.specification = specification;
        this.value = value;
        this.quantity = quantity;
        this.parameters =  parameters;
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

    public Collection<Parameters> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameters> parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EquipmentSpecification that = (EquipmentSpecification) o;

        if (sequenceNo != null ? !sequenceNo.equals(that.sequenceNo ) : that.sequenceNo != null)
            return false;
        return specification != null ? specification.equals(that.specification ) : that.specification == null;
    }

    @Override
    public int hashCode() {
        int result = sequenceNo != null ? sequenceNo.hashCode() : 0;
        result = 31 * result + (specification != null ? specification.hashCode() : 0);
        return result;
    }
}
