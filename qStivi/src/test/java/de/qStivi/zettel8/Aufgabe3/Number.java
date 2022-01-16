package de.qStivi.zettel8.Aufgabe3;

public interface Number {
    int toIntValue();

    void fromIntValue(int value);

    default void add(Number number) {
        this.fromIntValue(this.toIntValue() + number.toIntValue());
    }

    default void subtract(Number number) {
        this.fromIntValue(this.toIntValue() - number.toIntValue());
    }

    default void multiply(Number number) {
        this.fromIntValue(this.toIntValue() * number.toIntValue());
    }

    default void divide(Number number) {
        this.fromIntValue(this.toIntValue() / number.toIntValue());
    }
}
