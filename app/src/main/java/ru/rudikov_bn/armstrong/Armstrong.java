package ru.rudikov_bn.armstrong;

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.number.Numeral;

/**
 * Разработать программу для поиска чисел Армстронга в указываемом диапазоне десятичной системы счисления.
 * Число Армстронга, это число, которое в десятичной системе счисления,
 * равно сумме своих цифр, возведённых в степень, равную количеству его цифр.
 * Например, число 153, является числом Армстронга, поскольку 1^3 + 5^3 + 3^3 = 153
 */
public class Armstrong implements Tasks {
    public static boolean isVerify(int value) {
        int[] digits = Numeral.getDigits(value);
        int result = 0;
        for (int oneElement: digits){
            result += exponentiation(oneElement, digits.length);
        }
        return result == value;
    }

    private static int exponentiation(int value, int exponent){
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= value;
        }
        return result;
    }
}
