package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Material {

    @NotNull
    public String PartNo;
    public Integer Quantity;
    public String Description;


    public Material() {
        this.Quantity = 0;
    }

    public Material(String partNo, Integer quantity, String description) {
        this.PartNo = partNo;
        this.Quantity = quantity;
        this.Description = description;
    }

    public String getPartNo() {
        return PartNo;
    }

    public void setPartNo(String partNo) {
        this.PartNo = partNo;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        this.Quantity = quantity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Material))
            return false;
        Material that = (Material) o;
        return Objects.equals( PartNo, that.PartNo ) && Objects.equals( Quantity, that.Quantity ) && Objects.equals( Description, that.Description );
    }

    @Override
    public int hashCode() {

        return Objects.hash( PartNo, Quantity, Description );
    }
}
