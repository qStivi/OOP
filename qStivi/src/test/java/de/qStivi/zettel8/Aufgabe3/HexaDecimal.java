package de.qStivi.zettel8.Aufgabe3;

public class HexaDecimal implements Number {
    private String derWert;

    public HexaDecimal(String derWert) {
        this.derWert = derWert;
    }

    @Override
    public int toIntValue() {
        return Integer.parseInt(derWert, 16);
    }

    @Override
    public void fromIntValue(int value) {
        this.derWert = Integer.toHexString(value);
    }
}
