package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a ProcessStep containing a collection of Operations to execute and is identified by a sequence number
 * and a {@link WorkcellResource}
 */
public class ProcessStep {

    @NotNull
    private Integer plannedProductionTime;
    @NotNull
    private Integer sequenceNo;
    private WorkcellResource workcellResource;
    private Collection<Operation> billOfOperation;


    public ProcessStep(Integer plannedProductionTime, Integer sequenceNo, WorkcellResource workcellOperation, Collection<Operation> billOfOperation) {
        this.plannedProductionTime = plannedProductionTime;
        this.sequenceNo = sequenceNo;
        this.workcellResource = workcellOperation;
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

    public void setBillOfOperation(Collection<Operation> billofOperations) {
        this.billOfOperation = billofOperations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ProcessStep that = (ProcessStep) o;

        if (sequenceNo != null ? !sequenceNo.equals(that.sequenceNo ) : that.sequenceNo != null)
            return false;
        return workcellResource != null ? workcellResource.equals(that.workcellResource) : that.workcellResource == null;
    }

    @Override
    public int hashCode() {
        int result = sequenceNo != null ? sequenceNo.hashCode() : 0;
        result = 31 * result + (workcellResource != null ? workcellResource.hashCode() : 0);
        return result;
    }
}
