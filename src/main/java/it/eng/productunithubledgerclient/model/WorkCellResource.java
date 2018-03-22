package it.eng.productunithubledgerclient.model;

import java.util.Objects;

public class WorkCellResource {

    private String Id;
    private  String Name;

    public WorkCellResource() {
    }

    public WorkCellResource(String id, String name) {
        Id = id;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkCellResource)) return false;
        WorkCellResource that = (WorkCellResource) o;
        return Objects.equals( Id, that.Id ) && Objects.equals( Name, that.Name );
    }

    @Override
    public int hashCode() {

        return Objects.hash( Id, Name );
    }
}
