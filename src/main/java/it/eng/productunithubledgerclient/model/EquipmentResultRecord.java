package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class EquipmentResultRecord {
    @NotNull
    private Integer sequenceNo;
    private String result;
    private String value;
    private  String Quantity;

    public EquipmentResultRecord() {
    }

    public EquipmentResultRecord(Integer sequenceNo, String result, String value, String Quantity) {
        this.sequenceNo = sequenceNo;
        this.result = result;
        this.value = value;
        this.Quantity = Quantity;
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
        return Quantity;
    }

    public void setQuantity(String quantity) {
        this.Quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipmentResultRecord)) return false;
        EquipmentResultRecord that = (EquipmentResultRecord) o;
        return Objects.equals( sequenceNo, that.sequenceNo ) && Objects.equals( result, that.result ) && Objects.equals( value, that.value ) && Objects.equals( Quantity, that.Quantity );
    }

    @Override
    public int hashCode() {

        return Objects.hash( sequenceNo, result, value, Quantity );
    }}
