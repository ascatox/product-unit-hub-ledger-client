package it.eng.productunithubledgerclient.model;

import java.util.Objects;

public class Part {
    private String partNo;
    private String description;

    public Part(String partNo, String description) {
        this.partNo = partNo;
        this.description = description;
    }

    public Part() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Part)) return false;
        Part part = (Part) o;
        return Objects.equals( partNo, part.partNo ) && Objects.equals( description, part.description );
    }

    @Override
    public int hashCode() {

        return Objects.hash( partNo, description );
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
