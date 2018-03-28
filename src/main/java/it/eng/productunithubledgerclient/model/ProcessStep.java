package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a ProcessStep containing a collection of Operations to execute and is identified by a sequence number
 * and a {@link WorkCellResource}
 */
public class ProcessStep {

    @NotNull
    private Integer plannedProductionTime;
    @NotNull
    private Integer sequenceNo;
    private WorkCellResource workCellResource;
    private Collection<Operation> billofOperations;


    public ProcessStep(Integer plannedProductionTime, Integer sequenceNo, WorkCellResource workcellOperation, Collection<Operation> billofOperations) {
        this.plannedProductionTime = plannedProductionTime;
        this.sequenceNo = sequenceNo;
        this.workCellResource = workcellOperation;
        this.billofOperations = new ArrayList<>();
    }

    public ProcessStep() {
        this.billofOperations = new ArrayList<>();
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
     * This field {@link WorkCellResource} represents the WorkCell executing the process.
     * @return
     */
    public WorkCellResource getWorkCellResource() {
        return workCellResource;
    }

    public void setWorkCellResource(WorkCellResource workCellResource) {
        this.workCellResource = workCellResource;
    }

    /**
     * This field represents a collection of {@link Operation}
     * @return
     */
    public Collection<Operation> getBillofOperations() {
        return billofOperations;
    }

    public void setBillofOperations(Collection<Operation> billofOperations) {
        this.billofOperations = billofOperations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ProcessStep that = (ProcessStep) o;

        if (sequenceNo != null ? !sequenceNo.equals(that.sequenceNo) : that.sequenceNo != null)
            return false;
        return workCellResource != null ? workCellResource.equals(that.workCellResource) : that.workCellResource == null;
    }

    @Override
    public int hashCode() {
        int result = sequenceNo != null ? sequenceNo.hashCode() : 0;
        result = 31 * result + (workCellResource != null ? workCellResource.hashCode() : 0);
        return result;
    }
}
