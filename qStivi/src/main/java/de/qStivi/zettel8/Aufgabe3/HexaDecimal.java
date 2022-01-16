package de.qStivi.zettel8.Aufgabe3;

public class HexaDecimal implements Number {

    private String num;

    public HexaDecimal(String num) {
        this.num = num;
    }


    public int toIntValue() {
        String num = this.num.toUpperCase();
        final String hexString = "0123456789ABCDEF";
        int res = 0;
        for (int i = 0; i < num.length(); i++) {
            res += Math.pow(16, (num.length() - i - 1)) * hexString.indexOf(num.charAt(i));
        }
        return res;
    }

    private String toHexaValue(int value) {
        String res = "";
        final String hexString = "0123456789ABCDEF";
        while (value != 0) {
            int temp;
            temp = value % 16;
            res = hexString.charAt(temp) + res;
            value /= 16;
        }
        return res;
    }

    public void fromIntValue(int value) {
        this.num = toHexaValue(value);
    }

}
