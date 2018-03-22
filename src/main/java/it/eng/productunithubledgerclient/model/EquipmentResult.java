package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipmentResult {
    @NotNull
    private Integer sequenceNo;
    
    private String equipmentType;
    private List<EquipmentResultRecord> results;

    public EquipmentResult() {
        this.results = new ArrayList<>();
    }

    public EquipmentResult(Integer sequenceNo, String equipmentType, List<EquipmentResultRecord> results) {
        this.sequenceNo = sequenceNo;
        this.equipmentType = equipmentType;
        this.results = new ArrayList<>();
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public List<EquipmentResultRecord> getResults() {
        return results;
    }

    public void setResults(List<EquipmentResultRecord> results) {
        this.results = results;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipmentResult)) return false;
        EquipmentResult that = (EquipmentResult) o;
        return Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( equipmentType, that.equipmentType ) && Objects.equals( results, that.results );
    }

    @Override
    public int hashCode() {

        return Objects.hash( sequenceNo, equipmentType, results );
    }}
