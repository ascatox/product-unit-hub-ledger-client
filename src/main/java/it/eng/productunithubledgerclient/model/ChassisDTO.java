
package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotEmpty;
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
    private String chassisId;
    @NotNull
    private String component;
    @NotNull
    private String subComponent;

    private String productUnits;
    @NotEmpty
    private Collection<ProcessStep> BillOfProcessSteps;


    public ChassisDTO() {
        this.BillOfProcessSteps = new ArrayList<>();
    }

    public ChassisDTO(@NotNull String chassisId, @NotNull String component, @NotNull String subComponent, String productUnits,@NotEmpty List<ProcessStep> billOfProcessSteps) {
        this.chassisId = chassisId;
        this.component = component;
        this.subComponent = subComponent;
        this.productUnits = productUnits;
        this.BillOfProcessSteps = billOfProcessSteps;
    }

    /**
     * The chassisId {@link String} field represents the Chassis identifier and is part of the key.
     *
     * @return
     */

    public String getChassisId() {
        return chassisId;
    }

    public void setChassisId(String chassisId) {
        this.chassisId = chassisId;
    }

    /**
     * The component {@link String} field represents a part of the key
     *
     * @return
     */
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * The subComponent {@link String} field is the last part of the key identifier of Chassis.
     *
     * @return
     */
    public String getSubComponent() {
        return subComponent;
    }

    public void setSubComponent(String subComponent) {
        this.subComponent = subComponent;
    }

    /**
     * The productUnits {@link String} field contains the productUnit identifiers.
     * @return
     */
    public String getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(String productUnits) {
        this.productUnits = productUnits;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ChassisDTO that = (ChassisDTO) o;

        if (chassisId != null ? !chassisId.equals(that.chassisId ) : that.chassisId != null)
            return false;
        if (component != null ? !component.equals(that.component ) : that.component != null)
            return false;
        return subComponent != null ? subComponent.equals(that.subComponent ) : that.subComponent == null;
    }

    @Override
    public int hashCode() {
        int result = chassisId != null ? chassisId.hashCode() : 0;
        result = 31 * result + (component != null ? component.hashCode() : 0);
        result = 31 * result + (subComponent != null ? subComponent.hashCode() : 0);
        return result;
    }

}

