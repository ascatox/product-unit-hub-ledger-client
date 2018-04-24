package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EquipmentResult {
    @NotNull
    private Integer sequenceNo;
    private String equipmentType;
    private Collection<EquipmentResultRecord> results;

    public EquipmentResult() {
        this.results = new ArrayList<>();
        this.sequenceNo = 0;
    }

    public EquipmentResult(Integer sequenceNo, String equipmentType, Collection<EquipmentResultRecord> results) {
        this.sequenceNo = sequenceNo;
        this.equipmentType = equipmentType;
        this.results = results;
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

    public Collection<EquipmentResultRecord> getResults() {
        return results;
    }

    public void setResults(List<EquipmentResultRecord> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EquipmentResult that = (EquipmentResult) o;

        if (sequenceNo != null ? !sequenceNo.equals(that.sequenceNo ) : that.sequenceNo != null)
            return false;
        return equipmentType != null ? equipmentType.equals(that.equipmentType ) : that.equipmentType == null;
    }

    @Override
    public int hashCode() {
        int result = sequenceNo != null ? sequenceNo.hashCode() : 0;
        result = 31 * result + (equipmentType != null ? equipmentType.hashCode() : 0);
        return result;
    }
}
