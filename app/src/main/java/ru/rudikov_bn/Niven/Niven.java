package ru.rudikov_bn.Niven;

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.array.Array;
import ru.rudikov_bn.number.Numeral;

public class Niven implements Tasks {
//Разработать программу для поиска чисел Нивена. Числа Нивена – это натуральные числа, делящиеся нацело на сумму своих цифр. Например, число 1729,
// является числом Нивена, поскольку 1729 / (1 + 7 + 2 + 9) = 91, а 91 это целое числоРазработать программу для поиска чисел Нивена.
// Числа Нивена – это натуральные числа, делящиеся нацело на сумму своих цифр. Например, число 1729,
// является числом Нивена, поскольку 1729 / (1 + 7 + 2 + 9) = 91, а 91 это целое число

    public static boolean isVerify(int value) {
        int[] digits = Numeral.getDigits(value);
        int r = Array.additionItems(digits);

        if (r == 0) {
            return false;
        }

        return value % r == 0;
    }



}
