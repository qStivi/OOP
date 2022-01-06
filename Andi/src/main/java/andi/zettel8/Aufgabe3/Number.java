package andi.zettel8.Aufgabe3;

public interface Number {

    public int toIntValue();
    public void fromIntValue(int value);

    default public void add (Number number){
        int res = number.toIntValue();
        res += toIntValue();
        fromIntValue(res);
    }

    default public void subtract (Number number){
        int res = number.toIntValue();
        res -= toIntValue();
        fromIntValue(res);
    }

    default public void multiply (Number number){
        int res = number.toIntValue();
        res *= toIntValue();
        fromIntValue(res);
    }

    default public void divide (Number number){
        int res = number.toIntValue();
        res /= toIntValue();
        fromIntValue(res);
    }

}
