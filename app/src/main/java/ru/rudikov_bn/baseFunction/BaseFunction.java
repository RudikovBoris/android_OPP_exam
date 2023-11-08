package ru.rudikov_bn.baseFunction;

import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import ru.rudikov_bn.Niven.Niven;
import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.array.Array;
import ru.rudikov_bn.best_number.BestNumber;
import ru.rudikov_bn.lishler.Lishler;
import ru.rudikov_bn.log.LogWindow;
import ru.rudikov_bn.number.Numeral;
import ru.rudikov_bn.zuckerman.Zuckerman;

public class BaseFunction {
    LogWindow logWindow;
    EditText rangeStart;
    EditText rangeFinish;
    int start, finish;

    public BaseFunction(LogWindow logWindow, EditText rangeStart, EditText rangeFinish) {
        this.logWindow = logWindow;
        this.rangeStart = rangeStart;
        this.rangeFinish = rangeFinish;


    }

    public void getResultCalculation(Tasks tasks) {

        this.start = Integer.parseInt(rangeStart.getText().toString());
        this.finish = Integer.parseInt(rangeFinish.getText().toString());


        if (finish - start <= 0) {
            logWindow.out("Ошибка в диапазоне поиска");
            return;
        }

        if (finish - start > 1000) {
            logWindow.out("Не рационально длинный поиск");
            return;
        }


        logWindow.out(String.format("Диапазон поиска: от " + start + " до " + finish));

        logWindow.out("Поиск запущен");
        for (int i = start; i <= finish; ++i) {
            if (fabricTasks(tasks, i)) {
                logWindow.out(i);
            }
        }

        logWindow.out("Поиск завершен");
    }

    public static boolean fabricTasks(Tasks tasks, int number) {
        Tasks myClass;
        if (tasks.getClass().equals(Zuckerman.class)) {
            if (Zuckerman.isVerify(number)) {
                return true;
            }
        } else if (tasks.getClass().equals(Niven.class)) {
            if (Niven.isVerify(number)) {
                return true;
            }
        } else if (tasks.getClass().equals(Lishler.class)) {
            if (Lishler.isVerify(number)) {
                return true;
            }
        } else if (tasks.getClass().equals(BestNumber.class)) {
            if (BestNumber.isVerify(number)) {
                return true;
            }
        }
        return false;
    }
    public static int mirrorNumber(int number){
        int newNumber;
        String numberString = Integer.toString(number);
        String newMirrorNumberString = "";


        for (int i = numberString.length() - 1 ; 0 <= i ; i--) {
            newMirrorNumberString += numberString.charAt(i);
        }

        newNumber = Integer.parseInt(newMirrorNumberString);

        return newNumber;
    }

    public  static  boolean simpleNumber(int value){
        for (int i = 2; i < value; i++) {
            if (value % i == 0){
                return false;
            }

        }
        return true;
    }
    public static Map<Integer, Integer> getMapWithSimpleNumberForBiggestValue(int value){
        Map<Integer, Integer> simpleNumberWithThemCount = new HashMap<>();
        Integer countSimpleNumber = 0;
        if (value < BaseFunction.mirrorNumber(value)){
            value = BaseFunction.mirrorNumber(value);
        }
        for (int i = 2; i <= value; i++) {

            if(BaseFunction.simpleNumber(i)){
                countSimpleNumber++;
                simpleNumberWithThemCount.put((Integer) i, countSimpleNumber);
            }

        }
        return simpleNumberWithThemCount;
    }

    public static int getResultAdditionElementsNumber(int value){
        int[] digits = Numeral.getDigits(value);
        return Array.additionItems(digits);
    }

    public static int getResultMultiplicationElementsNumber(int value){
        int[] digits = Numeral.getDigits(value);
        return Array.multiplicationItems(digits);
    }

    public static boolean valueIsPalindrome(int value){
        int[] digits = Numeral.getDigits(value);
        int correctLengthHalfArray = getLengthArray(digits);
        boolean flagDigitsIsLishler = true;



        for (int i = 0; i < correctLengthHalfArray; i++) {
            int reverseCount = digits.length - i - 1;
            if (digits[i] != digits[reverseCount]) {
                flagDigitsIsLishler = false;
            }
        }
        return flagDigitsIsLishler;
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
