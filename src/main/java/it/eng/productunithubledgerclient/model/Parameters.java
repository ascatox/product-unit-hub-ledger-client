package it.eng.productunithubledgerclient.model;

import java.util.Objects;

public class Parameters {

    public String  Group;
    public String Id;
    public String Value;

    public Parameters() {
    }

    public Parameters(String group, String id, String value) {
        Group = group;
        Id = id;
        Value = value;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parameters)) return false;
        Parameters that = (Parameters) o;
        return Objects.equals( Group, that.Group ) && Objects.equals( Id, that.Id ) && Objects.equals( Value, that.Value );
    }

    @Override
    public int hashCode() {

        return Objects.hash( Group, Id, Value );
    }
}
