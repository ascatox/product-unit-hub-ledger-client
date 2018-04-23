package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EquipmentSpecification {
    @NotNull
    public Integer SequenceNo;
    public String Specification;
    public String Value;
    public Integer Quantity;
    public Collection<Parameters> Parameters;


    public EquipmentSpecification() {
        this.Parameters = new ArrayList<>(  );
        this.SequenceNo = 0;

    }

    public EquipmentSpecification(@NotNull Integer sequenceNo, String specification, String value, Integer quantity, Collection<Parameters> parameters) {
        this.SequenceNo = sequenceNo;
        this.Specification = specification;
        this.Value = value;
        this.Quantity = quantity;
        this.Parameters = new ArrayList<>(  );
    }

    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.SequenceNo = sequenceNo;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String specification) {
        this.Specification = specification;
    }

    public String getValue() {
        return Value;
    }



    public void setValue(String value) {
        this.Value = value;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        this.Quantity = quantity;
    }

    public Collection<Parameters> getParameters() {
        return Parameters;
    }

    public void setParameters(List<Parameters> parameters) {
        this.Parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EquipmentSpecification that = (EquipmentSpecification) o;

        if (SequenceNo != null ? !SequenceNo.equals(that.SequenceNo ) : that.SequenceNo != null)
            return false;
        return Specification != null ? Specification.equals(that.Specification ) : that.Specification == null;
    }

    @Override
    public int hashCode() {
        int result = SequenceNo != null ? SequenceNo.hashCode() : 0;
        result = 31 * result + (Specification != null ? Specification.hashCode() : 0);
        return result;
    }
}
