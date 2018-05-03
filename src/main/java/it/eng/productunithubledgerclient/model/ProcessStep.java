package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a ProcessStep containing a collection of Operations to execute and is identified by a sequence number
 * and a {@link WorkcellResource}
 */
public class ProcessStep {

    @NotNull
    private String id;
    private String name;
    @NotNull
    private Integer plannedProductionTime;
    @NotNull
    private Integer sequenceNo;
    @NotNull
    private WorkcellResource workcellResource;
    private Collection<Operation> billOfOperation;

    public ProcessStep(@NotNull String id, String name, @NotNull Integer plannedProductionTime, @NotNull Integer sequenceNo, @NotNull WorkcellResource workcellResource, Collection<Operation> billOfOperation) {
        this.id = id;
        this.name = name;
        this.plannedProductionTime = plannedProductionTime;
        this.sequenceNo = sequenceNo;
        this.workcellResource = workcellResource;
        this.billOfOperation = billOfOperation;
    }

    public ProcessStep() {
        this.billOfOperation = new ArrayList<>();
        this.plannedProductionTime = 0;
        this.sequenceNo = 0;
    }

    /**
     * This field {@link Integer}represents the planned production time.
     * @return
     */
    public Integer getPlannedProductionTime() {
        return plannedProductionTime;
    }

    public void setPlannedProductionTime(Integer plannedProductionTime) {
        this.plannedProductionTime = plannedProductionTime;
    }

    /**
     * This field {@link Integer} represents the sequence number.
     * @return
     */
    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    /**
     * This field {@link WorkcellResource} represents the WorkCell executing the process.
     * @return
     */
    public WorkcellResource getWorkcellResource() {
        return workcellResource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ProcessStep that = (ProcessStep) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setWorkcellResource(WorkcellResource workcellResource) {
        this.workcellResource = workcellResource;
    }

    /**
     * This field represents a collection of {@link Operation}
     * @return
     */
    public Collection<Operation> getBillOfOperation() {
        return billOfOperation;
    }

    public void setBillOfOperation(Collection<Operation> billofOperation) {
        this.billOfOperation = billofOperation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
