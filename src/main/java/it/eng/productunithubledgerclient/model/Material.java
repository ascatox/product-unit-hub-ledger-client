package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Material {

    @NotNull
    private Integer PartNo;
    private Integer Quantity;
    private String Description;


    public Material() {
    }

    public Material(Integer partNo, Integer quantity, String description) {
        PartNo = partNo;
        Quantity = quantity;
        Description = description;
    }

    public Integer getPartNo() {
        return PartNo;
    }

    public void setPartNo(Integer partNo) {
        PartNo = partNo;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        Material that = (Material) o;
        return Objects.equals( PartNo, that.PartNo ) && Objects.equals( Quantity, that.Quantity ) && Objects.equals( Description, that.Description );
    }

    @Override
    public int hashCode() {

        return Objects.hash( PartNo, Quantity, Description );
    }
}