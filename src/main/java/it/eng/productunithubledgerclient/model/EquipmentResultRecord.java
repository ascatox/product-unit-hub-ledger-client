package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;

public class EquipmentResultRecord {
    @NotNull
    private Integer SequenceNo;
    private String Result;
    private String Value;
    private String Quantity;

    public EquipmentResultRecord() {
        this.SequenceNo = 0;
    }

    public EquipmentResultRecord(Integer sequenceNo, String result, String value, String Quantity) {
        this.SequenceNo = sequenceNo;
        this.Result = result;
        this.Value = value;
        this.Quantity = Quantity;
    }

    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.SequenceNo = sequenceNo;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        this.Value = value;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        this.Quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EquipmentResultRecord that = (EquipmentResultRecord) o;

        return SequenceNo.equals(that.SequenceNo );
    }

    @Override
    public int hashCode() {
        return SequenceNo.hashCode();
    }
}
