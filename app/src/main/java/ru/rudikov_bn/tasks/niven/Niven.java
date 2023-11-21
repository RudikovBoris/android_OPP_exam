package ru.rudikov_bn.tasks.niven;

import static ru.rudikov_bn.base_function.BaseFunction.getResultAdditionElementsNumber;

import ru.rudikov_bn.Tasks;

/**
 * Разработать программу для поиска чисел Нивена. Числа Нивена – это натуральные числа, делящиеся нацело на сумму своих цифр. Например, число 1729,
 * является числом Нивена, поскольку 1729 / (1 + 7 + 2 + 9) = 91, а 91 это целое числоРазработать программу для поиска чисел Нивена.
 * Числа Нивена – это натуральные числа, делящиеся нацело на сумму своих цифр. Например, число 1729,
 * является числом Нивена, поскольку 1729 / (1 + 7 + 2 + 9) = 91, а 91 это целое число
 **/
public class Niven implements Tasks {

    public boolean isVerify(int value) {
        int r = getResultAdditionElementsNumber(value);

        if (r == 0) {
            return false;
        }

        return value % r == 0;
    }


}
