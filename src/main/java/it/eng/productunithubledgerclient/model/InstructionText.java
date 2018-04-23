package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class InstructionText implements Serializable {

    @NotNull
    private Integer sequenceNo;
    private String text;
    private String rtf;

    public InstructionText() {
        this.sequenceNo = 0;
    }

    public InstructionText(String text, String rtf, Integer SequenceNo) {
        this.sequenceNo = SequenceNo;
        this.text = text;
        this.rtf = rtf;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRtf() {
        return rtf;
    }

    public void setRtf(String rtf) {
        this.rtf = rtf;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    @Override
    public String toString() {
        return "InstructionText{" + "text='" + text + '\'' + ", rtf='" + rtf + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        InstructionText that = (InstructionText) o;

        if (sequenceNo != null ? !sequenceNo.equals(that.sequenceNo ) : that.sequenceNo != null)
            return false;
        if (text != null ? !text.equals(that.text ) : that.text != null)
            return false;
        return rtf != null ? rtf.equals(that.rtf ) : that.rtf == null;
    }

    @Override
    public int hashCode() {
        int result = sequenceNo != null ? sequenceNo.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (rtf != null ? rtf.hashCode() : 0);
        return result;
    }
}
