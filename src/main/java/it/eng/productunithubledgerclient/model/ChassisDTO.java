
package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class represents a Chassis containing a collection of ProcessSteps {@link ProcessStep} to be executed.<br/>
 * <b>This DTO shares data with the Chaincode</b>.
 */

public class ChassisDTO implements Serializable {


    @NotNull
    private String ChassisId;
    @NotNull
    private String Component;
    @NotNull
    private String SubComponent;

    private String ProductUnits;

    private Collection<ProcessStep> BillOfProcessSteps;


    public ChassisDTO() {
        this.BillOfProcessSteps = new ArrayList<>();
    }

    public ChassisDTO(@NotNull String chassisId, @NotNull String component, @NotNull String subComponent, String productUnits, List<ProcessStep> billOfProcessSteps) {
        this.ChassisId = chassisId;
        this.Component = component;
        this.SubComponent = subComponent;
        this.ProductUnits = productUnits;
        this.BillOfProcessSteps = new ArrayList<>();
    }

    /**
     * The ChassisId {@link String} field represents the Chassis identifier and is part of the key.
     *
     * @return
     */
    public String getChassisId() {
        return ChassisId;
    }

    public void setChassisId(String chassisId) {
        this.ChassisId = chassisId;
    }

    /**
     * The Component {@link String} field represents a part of the key
     *
     * @return
     */
    public String getComponent() {
        return Component;
    }

    public void setComponent(String component) {
        this.Component = component;
    }

    /**
     * The SubComponent {@link String} field is the last part of the key identifier of Chassis.
     *
     * @return
     */
    public String getSubComponent() {
        return SubComponent;
    }

    public void setSubComponent(String subComponent) {
        this.SubComponent = subComponent;
    }

    /**
     * The ProductUnits {@link String} field contains the productUnit identifiers.
     * @return
     */
    public String getProductUnits() {
        return ProductUnits;
    }

    public void setProductUnits(String productUnits) {
        this.ProductUnits = productUnits;
    }


    public void setBillOfProcessSteps(Collection<ProcessStep> billOfProcessSteps) {
        this.BillOfProcessSteps = billOfProcessSteps;
    }

    /**
     * This field contains the collection of ProcessStep {@link ProcessStep}
     * @return
     */
    public Collection<ProcessStep> getBillOfProcessSteps() {
        return BillOfProcessSteps;
    }

    public void setBillOfProcessSteps(List<ProcessStep> billOfProcessSteps) {
        this.BillOfProcessSteps = billOfProcessSteps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ChassisDTO that = (ChassisDTO) o;

        if (ChassisId != null ? !ChassisId.equals(that.ChassisId ) : that.ChassisId != null)
            return false;
        if (Component != null ? !Component.equals(that.Component ) : that.Component != null)
            return false;
        return SubComponent != null ? SubComponent.equals(that.SubComponent ) : that.SubComponent == null;
    }

    @Override
    public int hashCode() {
        int result = ChassisId != null ? ChassisId.hashCode() : 0;
        result = 31 * result + (Component != null ? Component.hashCode() : 0);
        result = 31 * result + (SubComponent != null ? SubComponent.hashCode() : 0);
        return result;
    }

}

