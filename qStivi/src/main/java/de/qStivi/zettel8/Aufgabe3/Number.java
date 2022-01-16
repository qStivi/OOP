package de.qStivi.zettel8.Aufgabe3;

public interface Number {

    int toIntValue();

    void fromIntValue(int value);

    default void add(Number number) {
        int res = number.toIntValue();
        res += toIntValue();
        fromIntValue(res);
    }

    default void subtract(Number number) {
        int res = number.toIntValue();
        res -= toIntValue();
        fromIntValue(res);
    }

    default void multiply(Number number) {
        int res = number.toIntValue();
        res *= toIntValue();
        fromIntValue(res);
    }

    default void divide(Number number) {
        int res = number.toIntValue();
        res /= toIntValue();
        fromIntValue(res);
    }

}
