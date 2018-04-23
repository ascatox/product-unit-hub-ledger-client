package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;

public class EquipmentResultRecord {
    @NotNull
    private Integer sequenceNo;
    private String result;
    private String value;
    private String quantity;

    public EquipmentResultRecord() {
        this.sequenceNo = 0;
    }

    public EquipmentResultRecord(Integer sequenceNo, String result, String value, String Quantity) {
        this.sequenceNo = sequenceNo;
        this.result = result;
        this.value = value;
        this.quantity = Quantity;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EquipmentResultRecord that = (EquipmentResultRecord) o;

        return sequenceNo.equals(that.sequenceNo );
    }

    @Override
    public int hashCode() {
        return sequenceNo.hashCode();
    }
}
