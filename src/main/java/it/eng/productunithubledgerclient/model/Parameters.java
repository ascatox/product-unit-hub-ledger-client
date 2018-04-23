package it.eng.productunithubledgerclient.model;

import java.util.Objects;

public class Parameters {

    public String group;
    public String id;
    public String value;

    public Parameters() {
    }

    public Parameters(String group, String id, String value) {
        this.group = group;
        this.id = id;
        this.value = value;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parameters)) return false;
        Parameters that = (Parameters) o;
        return Objects.equals( group, that.group ) && Objects.equals( id, that.id ) && Objects.equals( value, that.value );
    }

    @Override
    public int hashCode() {

        return Objects.hash( group, id, value );
    }
}
