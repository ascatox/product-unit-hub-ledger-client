package it.eng.productunithubledgerclient.model;

import java.util.Objects;

public class ChassisID {

    private String chassisId;
    private String component;
    private String subComponent;

    public ChassisID() {
    }

    public ChassisID(String chassisId, String component, String subComponent) {
        this.chassisId = chassisId;
        this.component = component;
        this.subComponent = subComponent;
    }

    public String getChassisId() {
        return chassisId;
    }

    public void setChassisId(String chassisId) {
        this.chassisId = chassisId;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getSubComponent() {
        return subComponent;
    }

    public void setSubComponent(String subComponent) {
        this.subComponent = subComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChassisID)) return false;
        ChassisID chassisID = (ChassisID) o;
        return Objects.equals( chassisId, chassisID.chassisId ) && Objects.equals( component, chassisID.component ) && Objects.equals( subComponent, chassisID.subComponent );
    }

    @Override
    public int hashCode() {

        return Objects.hash( chassisId, component, subComponent );
    }
}
