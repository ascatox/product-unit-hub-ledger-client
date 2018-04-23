package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Material {

    @NotNull
    public String partNo;
    public Integer quantity;
    public String description;


    public Material() {
        this.quantity = 0;
    }

    public Material(String partNo, Integer quantity, String description) {
        this.partNo = partNo;
        this.quantity = quantity;
        this.description = description;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Material))
            return false;
        Material that = (Material) o;
        return Objects.equals( partNo, that.partNo ) && Objects.equals( quantity, that.quantity ) && Objects.equals( description, that.description );
    }

    @Override
    public int hashCode() {

        return Objects.hash( partNo, quantity, description );
    }
}
