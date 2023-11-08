package ru.rudikov_bn.lishler;


//Разработать программу для поиска чисел Лишрел. Число Лишрел – это натуральное число,
// которое не может стать палиндромом с помощью итеративного процесса «перевернуть и сложить» в десятичной системе счисления.
// Например, число 56 становится палиндромом после одной итерации: 56 + 65 = 121.
// Число 57 становится палиндромом после двух итераций: 57 + 75 = 132, 132 + 231 = 363.
// Число 59 становится палиндромом после трех итераций: 59 + 95 = 154, 154 + 451 = 605, 605 + 506 = 1111.

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.number.Numeral;

public class Lishler implements Tasks {
    public static boolean isVerify(int value) {
        Integer countAddingNumberMirror = 1;
        return startLogic(value, countAddingNumberMirror);
    }

    public static boolean startLogic(int value, Integer countAddingNumberMirror){
        int[] digits = Numeral.getDigits(value);
        int correctLengthHalfArray = getLengthArray(digits);
        boolean flagDigitsIsLishler = true;



        for (int i = 0; i < correctLengthHalfArray; i++) {
            int reverseCount = digits.length - i - 1;
            if (digits[i] != digits[reverseCount]) {
                flagDigitsIsLishler = false;
            }
        }

        if((countAddingNumberMirror < 10) && (flagDigitsIsLishler == false)){
            countAddingNumberMirror ++;
            return startLogic(addingNumberMirror(value), countAddingNumberMirror);

        }


        if (flagDigitsIsLishler){
            return true;
        }else {
            return false;
        }
    }
    

    private static int addingNumberMirror(int number){
        int newNumber;
        String numberString = Integer.toString(number);
        String newMirrorNumberString = "";


        for (int i = numberString.length() - 1 ; 0 <= i ; i--) {
            newMirrorNumberString += numberString.charAt(i);
        }

        newNumber = Integer.parseInt(newMirrorNumberString);

        return number + newNumber;
    }

    private static int getLengthArray(int[] digits) {
        int newLengthArray;

        if (digits.length % 2 != 0) {
            newLengthArray = digits.length / 2 + 1;
        } else {
            newLengthArray = (digits.length / 2);
        }

        return newLengthArray;

    }


}
