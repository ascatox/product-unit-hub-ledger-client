package it.eng.productunithubledgerclient.model;

import java.util.Objects;

/**
 * This class represents the WorkCell.
 */
public class WorkCellResource {

    private String id;
    private String name;

    public WorkCellResource() {
    }

    public WorkCellResource(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * This field {@link String} represents the identifier of the WorkCell.
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * This field {@link String} represents the name of the WorkCell.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof WorkCellResource))
            return false;
        WorkCellResource that = (WorkCellResource) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
