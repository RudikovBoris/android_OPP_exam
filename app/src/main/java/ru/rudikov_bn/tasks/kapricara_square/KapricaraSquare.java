package ru.rudikov_bn.tasks.kapricara_square;

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.number.Numeral;

/**
 * Разработать программу для поиска чисел Капрекара в указываемом диапазоне десятичной системы счисления.
 * Число Капрекара - это неотрицательное целое число, квадрат которого можно разбить на две части, сумма которых даёт исходное число.
 * Например, 45 - число Капрекара, поскольку 45^2 = 2025 и 20 + 25 = 45.
 * 297 - число Капрекара, поскольку 297^2 = 88209, и 88 + 209 = 297.
 * 999 - число Капрекара, поскольку 999^2 = 998001, и 998 + 001 = 999.
 * 100 - не число Капрекара, хотя 100^2 = 10000 и 100 + 00 = 100, но вторая часть равна нулю.
 * Примечание: вторая часть может начинаться с 0, но не должна быть нулевой.
 * Пояснение: суммирование частей числа, реализовать последовательным перебором, т.е,
 * например для числа 88209 - сначала проверить 8+8209, потом 88+209, 882+09,
 * 8820+9 и каждую из таких сумм сравнивать с исходным числом
 */
public class KapricaraSquare implements Tasks {

    public boolean isVerify(int value) {
        int square = value * value;
        int[] digitsSquare = Numeral.getDigits(square);
        for (int i = 0; i < digitsSquare.length - 1; i++) {

            StringBuilder stringBuilderFirstNumber = new StringBuilder();
            StringBuilder stringBuilderSecondNumber = new StringBuilder();

            for (int firstNumber = 0; firstNumber <= i; firstNumber++) {
                stringBuilderFirstNumber.append(digitsSquare[firstNumber]);
            }
            for (int secondNumber = i + 1; secondNumber < digitsSquare.length; secondNumber++) {
                stringBuilderSecondNumber.append(digitsSquare[secondNumber]);
            }
            int firstNumber = Integer.parseInt(String.valueOf(stringBuilderFirstNumber));
            int secondNumber = Integer.parseInt(String.valueOf(stringBuilderSecondNumber));
            if (firstNumber + secondNumber == value) {
                return true;
            }
        }
        return false;
    }

}
