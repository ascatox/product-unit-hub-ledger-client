package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * This class represents a Workcell.
 */
public class WorkcellResource {
    @NotNull
    private String id;
    private String name;

    public WorkcellResource() {
    }

    public WorkcellResource(@NotNull String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * This field {@link String} represents the identifier of the Workcell.
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
     * This field {@link String} represents the name of the Workcell.
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
        if (!(o instanceof WorkcellResource))
            return false;
        WorkcellResource that = (WorkcellResource) o;
        return Objects.equals( id, that.id ) && Objects.equals( name, that.name );
    }

    @Override
    public int hashCode() {

        return Objects.hash( id, name );
    }
}
