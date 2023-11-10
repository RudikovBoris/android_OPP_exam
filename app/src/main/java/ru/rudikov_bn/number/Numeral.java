package ru.rudikov_bn.number;

public class Numeral {
    private Numeral() {
    }

    public static int[] getDigits(int value) {
        String buf = Integer.toString(value);

        final int dc = buf.length();
        int[] digits = new int[dc];
        for (int i = 0; i < dc; ++i) {
            digits[i] = Character.getNumericValue(buf.charAt(i));
        }

        return digits;
    }

}
