package it.eng.productunithubledgerclient.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class InstructionText implements Serializable {

    @NotNull
    private Integer SequenceNo;

    private String text;
    private String rtf;

    public InstructionText() {
    }

    public InstructionText(String text, String rtf, Integer SequenceNo) {
        this.SequenceNo = SequenceNo;
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
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        SequenceNo = sequenceNo;
    }

    @Override
    public String toString() {
        return "InstructionText{" + "text='" + text + '\'' + ", rtf='" + rtf + '\'' + '}';
    }


}
