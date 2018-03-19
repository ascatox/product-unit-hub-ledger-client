package it.eng.productunithubledgerclient.model;

import java.io.Serializable;
import java.util.Objects;

public class InstructionText implements Serializable {
    private String text;
    private String rtf;

    public InstructionText() {
    }

    public InstructionText(String text, String rtf) {
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

    @Override
    public String toString() {
        return "InstructionText{" + "text='" + text + '\'' + ", rtf='" + rtf + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InstructionText)) return false;
        InstructionText that = (InstructionText) o;
        return Objects.equals( text, that.text ) && Objects.equals( rtf, that.rtf );
    }

    @Override
    public int hashCode() {
        return Objects.hash( text, rtf );
    }

}
