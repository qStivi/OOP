public interface Number {

    int toIntValue(); //Gibt Wert zurück

    void fromIntValue(int value); //Weist Wert zu

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
