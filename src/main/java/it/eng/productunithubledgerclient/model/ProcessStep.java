package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProcessStep {

    @NotNull
    private Integer plannedProductionTime;
    @NotNull
    private Integer sequenceNo;

    private WorkCellResource workCellResource;
    private List<Operation> billofOperations;


    public ProcessStep(Integer plannedProductionTime, Integer sequenceNo, String Id, String Name, WorkCellResource workcellOperation, List<Operation> billofOperations) {
        this.plannedProductionTime = plannedProductionTime;
        this.sequenceNo = sequenceNo;
        this.workCellResource = workcellOperation;
        this.billofOperations = new ArrayList<>();

    }

    public ProcessStep() {
        this.billofOperations = new ArrayList<>();
    }

    public Integer getPlannedProductionTime() {
        return plannedProductionTime;
    }

    public void setPlannedProductionTime(Integer plannedProductionTime) {
        this.plannedProductionTime = plannedProductionTime;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }


    public WorkCellResource getWorkCellResource() {
        return workCellResource;
    }

    public void setWorkCellResource(WorkCellResource workCellResource) {
        this.workCellResource = workCellResource;
    }

    public List<Operation> getBillofOperations() {
        return billofOperations;
    }

    public void setBillofOperations(List<Operation> billofOperations) {
        this.billofOperations = billofOperations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessStep)) return false;
        ProcessStep that = (ProcessStep) o;
        return Objects.equals( plannedProductionTime, that.plannedProductionTime ) && Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( workCellResource, that.workCellResource ) && Objects.equals( billofOperations, that.billofOperations );
    }

    @Override
    public int hashCode() {

        return Objects.hash( plannedProductionTime, sequenceNo, workCellResource, billofOperations );
    }}
