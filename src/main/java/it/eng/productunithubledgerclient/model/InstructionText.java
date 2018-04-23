package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class InstructionText implements Serializable {

    @NotNull
    private Integer SequenceNo;
    private String Text;
    private String Rtf;

    public InstructionText() {
        this.SequenceNo = 0;
    }

    public InstructionText(String text, String rtf, Integer SequenceNo) {
        this.SequenceNo = SequenceNo;
        this.Text = text;
        this.Rtf = rtf;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        this.Text = text;
    }

    public String getRtf() {
        return Rtf;
    }

    public void setRtf(String rtf) {
        this.Rtf = rtf;
    }

    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.SequenceNo = sequenceNo;
    }

    @Override
    public String toString() {
        return "InstructionText{" + "Text='" + Text + '\'' + ", Rtf='" + Rtf + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        InstructionText that = (InstructionText) o;

        if (SequenceNo != null ? !SequenceNo.equals(that.SequenceNo ) : that.SequenceNo != null)
            return false;
        if (Text != null ? !Text.equals(that.Text ) : that.Text != null)
            return false;
        return Rtf != null ? Rtf.equals(that.Rtf ) : that.Rtf == null;
    }

    @Override
    public int hashCode() {
        int result = SequenceNo != null ? SequenceNo.hashCode() : 0;
        result = 31 * result + (Text != null ? Text.hashCode() : 0);
        result = 31 * result + (Rtf != null ? Rtf.hashCode() : 0);
        return result;
    }
}
