package ru.rudikov_bn.lishler;


/**
 * Разработать программу для поиска чисел Лишрел. Число Лишрел – это натуральное число,
 * которое не может стать палиндромом с помощью итеративного процесса «перевернуть и сложить» в десятичной системе счисления.
 * Например, число 56 становится палиндромом после одной итерации: 56 + 65 = 121.
 * Число 57 становится палиндромом после двух итераций: 57 + 75 = 132, 132 + 231 = 363.
 * Число 59 становится палиндромом после трех итераций: 59 + 95 = 154, 154 + 451 = 605, 605 + 506 = 1111.
 **/

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.base_function.BaseFunction;

public class Lishler implements Tasks {

    public boolean isVerify(int value) {
        Integer countAddingNumberMirror = 1;
        return startLogic(value, countAddingNumberMirror);
    }

    public static boolean startLogic(int value, Integer countAddingNumberMirror) {

        boolean flagDigitsIsLishler = BaseFunction.valueIsPalindrome(value);

        if ((countAddingNumberMirror < 10) && flagDigitsIsLishler) {
            countAddingNumberMirror++;
            int addMirrorAndValue = value + BaseFunction.mirrorNumber(value);
            return startLogic(addMirrorAndValue, countAddingNumberMirror);

        }

        return flagDigitsIsLishler;
    }


}
