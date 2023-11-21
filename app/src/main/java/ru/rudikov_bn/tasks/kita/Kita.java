package ru.rudikov_bn.tasks.kita;

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.number.Numeral;


/**
 * Разработать программу для поиска чисел Кита в указываемом диапазоне. Число Кита определяется следующим образом, например:
 * <p>
 * Число 14:
 * 1) разделить исходное число (14) на цифры: 1 и 4
 * 2) выполнить следующие действия:
 * 1 + 4 = 5
 * 4 + 5 = 9
 * 5 + 9 = 14
 * Поскольку получилось число равное исходному числу (14), то это число Кита. Как только число начнет превышать исходное, то это не число Кита. Проверить, вдруг если превышает, то рано или поздно станет числом Кита
 * <p>
 * Число 197
 * 1) разделить исходное число (197) на цифры: 1, 9 и 7
 * 2) выполнить следующие действия:
 * 1 + 9 + 7 = 17
 * 9 + 7 + 17 = 33
 * 7 + 17 + 33 = 57
 * 17 + 33 + 57 = 107
 * 33 + 57 + 107 = 197
 * Поскольку получилось число равное исходному числу (197), то это число Кита. Как только число начнет превышать исходное, то это не число Кита
 **/
public class Kita implements Tasks {

    public boolean isVerify(int value) {
        int[] digits = Numeral.getDigits(value);
        int[] templeArray = searchKeta(digits);
        while (templeArray[templeArray.length - 1] < value) {
            templeArray = searchKeta(templeArray);
            if (templeArray[templeArray.length - 1] == value) {
                return true;
            }
        }
        return false;
    }

    private int[] searchKeta(int[] digits) {
        int[] templeArray = new int[digits.length];
        int templeResult = 0;
        for (int i = 0; i < digits.length; i++) {

            templeResult += digits[i];

            if (i > 0) {
                templeArray[i - 1] = digits[i];
            }

        }

        templeArray[templeArray.length - 1] = templeResult;

        return templeArray;
    }
}
