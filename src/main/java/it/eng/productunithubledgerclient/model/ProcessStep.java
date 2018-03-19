package it.eng.productunithubledgerclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProcessStep{

    private String plannedProductionTime;
    private Integer sequenceNo;
    private String workcellOperation;
    private List<Operation> billofOperations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessStep)) return false;
        ProcessStep that = (ProcessStep) o;
        return Objects.equals( plannedProductionTime, that.plannedProductionTime ) && Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( workcellOperation, that.workcellOperation ) && Objects.equals( billofOperations, that.billofOperations );
    }

    @Override
    public int hashCode() {

        return Objects.hash( plannedProductionTime, sequenceNo, workcellOperation, billofOperations );
    }

    public ProcessStep(String plannedProductionTime, Integer sequenceNo, String workcellOperation, List<Operation> billofOperations) {
        this.plannedProductionTime = plannedProductionTime;
        this.sequenceNo = sequenceNo;
        this.workcellOperation = workcellOperation;
        this.billofOperations = new ArrayList<>();
    }

    public ProcessStep() {
        this.billofOperations = new ArrayList<>();
    }

    public String getPlannedProductionTime() {
        return plannedProductionTime;
    }

    public void setPlannedProductionTime(String plannedProductionTime) {
        this.plannedProductionTime = plannedProductionTime;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getWorkcellOperation() {
        return workcellOperation;
    }

    public void setWorkcellOperation(String workcellOperation) {
        this.workcellOperation = workcellOperation;
    }

    public List<Operation> getBillofOperations() {
        return billofOperations;
    }

    public void setBillofOperations(List<Operation> billofOperations) {
        this.billofOperations = billofOperations;
    }
}
