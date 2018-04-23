package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EquipmentResult {
    @NotNull
    private Integer SequenceNo;
    private String EquipmentType;
    private Collection<EquipmentResultRecord> Results;

    public EquipmentResult() {
        this.Results = new ArrayList<>();
        this.SequenceNo = 0;
    }

    public EquipmentResult(Integer sequenceNo, String equipmentType, Collection<EquipmentResultRecord> results) {
        this.SequenceNo = sequenceNo;
        this.EquipmentType = equipmentType;
        this.Results = new ArrayList<>();
    }

    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.SequenceNo = sequenceNo;
    }

    public String getEquipmentType() {
        return EquipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.EquipmentType = equipmentType;
    }

    public Collection<EquipmentResultRecord> getResults() {
        return Results;
    }

    public void setResults(List<EquipmentResultRecord> results) {
        this.Results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EquipmentResult that = (EquipmentResult) o;

        if (SequenceNo != null ? !SequenceNo.equals(that.SequenceNo ) : that.SequenceNo != null)
            return false;
        return EquipmentType != null ? EquipmentType.equals(that.EquipmentType ) : that.EquipmentType == null;
    }

    @Override
    public int hashCode() {
        int result = SequenceNo != null ? SequenceNo.hashCode() : 0;
        result = 31 * result + (EquipmentType != null ? EquipmentType.hashCode() : 0);
        return result;
    }
}
