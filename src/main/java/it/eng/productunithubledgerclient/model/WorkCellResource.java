package it.eng.productunithubledgerclient.model;

import java.util.Objects;

/**
 * This class represents a WorkCell.
 */
public class WorkCellResource {

    private String Id;
    private String Name;

    public WorkCellResource() {
    }

    public WorkCellResource(String id, String name) {
        this.Id = id;
        this.Name = name;
    }

    /**
     * This field {@link String} represents the identifier of the WorkCell.
     *
     * @return
     */
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    /**
     * This field {@link String} represents the Name of the WorkCell.
     *
     * @return
     */
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof WorkCellResource))
            return false;
        WorkCellResource that = (WorkCellResource) o;
        return Objects.equals( Id, that.Id ) && Objects.equals( Name, that.Name );
    }

    @Override
    public int hashCode() {

        return Objects.hash( Id, Name );
    }
}
