package de.qStivi.zettel8.Aufgabe3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexaDecimalTest {

    @Test
    void add() {
        var num = new HexaDecimal("1");
        var num2 = new HexaDecimal("1");
        num.add(num2);
        assertEquals(2, num.toIntValue());
    }

    @Test
    void add2() {
        var num = new HexaDecimal("FF");
        var num2 = new HexaDecimal("1");
        num.add(num2);
        assertEquals(256, num.toIntValue());
    }

    @Test
    void subtract() {
        var num = new HexaDecimal("1");
        var num2 = new HexaDecimal("1");
        num.subtract(num2);
        assertEquals(0, num.toIntValue());
    }

    @Test
    void subtract2() {
        var num = new HexaDecimal("FF");
        var num2 = new HexaDecimal("1");
        num.subtract(num2);
        assertEquals(254, num.toIntValue());
    }

    @Test
    void multiply() {
        var num = new HexaDecimal("1");
        var num2 = new HexaDecimal("1");
        num.multiply(num2);
        assertEquals(1, num.toIntValue());
    }

    @Test
    void multiply3() {
        var num = new HexaDecimal("10");
        var num2 = new HexaDecimal("3");
        num.multiply(num2);
        assertEquals(48, num.toIntValue());
    }

    @Test
    void divide() {
        var num = new HexaDecimal("1");
        var num2 = new HexaDecimal("1");
        num.divide(num2);
        assertEquals(1, num.toIntValue());
    }

    @Test
    void divide2() {
        var num = new HexaDecimal("10");
        var num2 = new HexaDecimal("2");
        num.divide(num2);
        assertEquals(8, num.toIntValue());
    }

    @Test
    void toIntValue() {
        var num = new HexaDecimal("1");
        assertEquals(1, num.toIntValue());
    }

    @Test
    void toIntValue2() {
        var num = new HexaDecimal("FF");
        assertEquals(255, num.toIntValue());
    }

    @Test
    void fromIntValue() {
        var num = new HexaDecimal("FF");
        num.fromIntValue(1);
        assertEquals(1, num.toIntValue());
    }

    @Test
    void fromIntValu2() {
        var num = new HexaDecimal("FF");
        num.fromIntValue(1337);
        assertEquals(1337, num.toIntValue());
    }
}