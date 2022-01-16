package julian.zettel8;
public class HexaDecimal implements Number {

    private String value;

    public HexaDecimal(String value) {
        this.value = value;
    }

    @Override
    public int toIntValue() {

        char[] numbers = this.value.toCharArray();
        int intValue = 0;
        int exponent = 0;

        for(int i = numbers.length - 1; i >= 0; i--) {
            int valueInDec = Character.getNumericValue(numbers[i]);
            switch (numbers[i]) {
                case 'A' -> valueInDec = 10;
                case 'B' -> valueInDec = 11;
                case 'C' -> valueInDec = 12;
                case 'D' -> valueInDec = 13;
                case 'E' -> valueInDec = 14;
                case 'F' -> valueInDec = 15;
            }
            intValue = (int) (intValue + Math.pow(16, exponent) *  valueInDec);
            exponent++;
        }
        return intValue;
    }

    @Override
    public void fromIntValue(int value) { //Dezimal in Hexadezimal

        StringBuilder sb = new StringBuilder();

        while(value > 0) {

            String remainder = String.valueOf(value % 16);
            switch(remainder) {
                case "10" -> remainder = "A";
                case "11" -> remainder = "B";
                case "12" -> remainder = "C";
                case "13" -> remainder = "D";
                case "14" -> remainder = "E";
                case "15" -> remainder = "F";
            }
            sb.append(remainder);
            value = value / 16;
        }
        this.value = sb.reverse().toString();
    }

    @Override
    public String toString() {
        return "HexaDecimal{" +
                "value='" + value + '\'' +
                '}';
    }

}
