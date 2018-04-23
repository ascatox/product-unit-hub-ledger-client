package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a ProcessStep containing a collection of Operations to execute and is identified by a sequence number
 * and a {@link WorkCellResource}
 */
public class ProcessStep {

    @NotNull
    private Integer PlannedProductionTime;
    @NotNull
    private Integer SequenceNo;
    private WorkCellResource WorkCellResource;
    private Collection<Operation> BillofOperations;


    public ProcessStep(Integer plannedProductionTime, Integer sequenceNo, WorkCellResource workcellOperation, Collection<Operation> billofOperations) {
        this.PlannedProductionTime = plannedProductionTime;
        this.SequenceNo = sequenceNo;
        this.WorkCellResource = workcellOperation;
        this.BillofOperations = new ArrayList<>();
    }

    public ProcessStep() {
        this.BillofOperations = new ArrayList<>();
        this.PlannedProductionTime = 0;
        this.SequenceNo = 0;
    }

    /**
     * This field {@link Integer}represents the planned production time.
     * @return
     */
    public Integer getPlannedProductionTime() {
        return PlannedProductionTime;
    }

    public void setPlannedProductionTime(Integer plannedProductionTime) {
        this.PlannedProductionTime = plannedProductionTime;
    }

    /**
     * This field {@link Integer} represents the sequence number.
     * @return
     */
    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.SequenceNo = sequenceNo;
    }

    /**
     * This field {@link WorkCellResource} represents the WorkCell executing the process.
     * @return
     */
    public WorkCellResource getWorkCellResource() {
        return WorkCellResource;
    }

    public void setWorkCellResource(WorkCellResource workCellResource) {
        this.WorkCellResource = workCellResource;
    }

    /**
     * This field represents a collection of {@link Operation}
     * @return
     */
    public Collection<Operation> getBillofOperations() {
        return BillofOperations;
    }

    public void setBillofOperations(Collection<Operation> billofOperations) {
        this.BillofOperations = billofOperations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ProcessStep that = (ProcessStep) o;

        if (SequenceNo != null ? !SequenceNo.equals(that.SequenceNo ) : that.SequenceNo != null)
            return false;
        return WorkCellResource != null ? WorkCellResource.equals(that.WorkCellResource ) : that.WorkCellResource == null;
    }

    @Override
    public int hashCode() {
        int result = SequenceNo != null ? SequenceNo.hashCode() : 0;
        result = 31 * result + (WorkCellResource != null ? WorkCellResource.hashCode() : 0);
        return result;
    }
}
