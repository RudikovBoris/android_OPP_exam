package ru.rudikov_bn.base_function;

import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import ru.rudikov_bn.armstrong.Armstrong;
import ru.rudikov_bn.friends_number.FriendsNumber;
import ru.rudikov_bn.kaprecara.Kapricara;
import ru.rudikov_bn.kapricara_square.KapricaraSquare;
import ru.rudikov_bn.kita_package.Kita;
import ru.rudikov_bn.niven_pacage.Niven;
import ru.rudikov_bn.array.Array;
import ru.rudikov_bn.best_number.BestNumber;
import ru.rudikov_bn.happy_number.HappyNumber;
import ru.rudikov_bn.lishler.Lishler;
import ru.rudikov_bn.log.LogWindow;
import ru.rudikov_bn.number.Numeral;
import ru.rudikov_bn.zuckerman.Zuckerman;

public class BaseFunction {
    LogWindow logWindow;
    EditText rangeStart;
    EditText rangeFinish;
    int start;
    int finish;

    public BaseFunction(LogWindow logWindow, EditText rangeStart, EditText rangeFinish) {
        this.logWindow = logWindow;
        this.rangeStart = rangeStart;
        this.rangeFinish = rangeFinish;


    }

    public void getResultCalculation(Class tasks) {

        if (!rangeStart.getText().toString().equals("")) {
            this.start = Integer.parseInt(rangeStart.getText().toString());
        } else {
            logWindow.out("Не устанвленно первое число");
            return;
        }

        if (!rangeFinish.getText().toString().equals("")) {
            this.finish = Integer.parseInt(rangeFinish.getText().toString());
        } else {
            logWindow.out("Не установленно второе число");
            return;
        }
        if (finish - start <= 0) {
            logWindow.out("Ошибка в диапазоне поиска");
            return;
        }

        if (finish - start > 1000) {
            logWindow.out("Не рационально длинный поиск");
            return;
        }


        logWindow.out(String.format("Диапазон поиска: от %s  до %s %n", start, finish));

        logWindow.out("Поиск запущен");
        for (int i = start; i <= finish; ++i) {
            if (fabricTasks(tasks, i)) {
                logWindow.out(i);
            }
        }

        logWindow.out("Поиск завершен");
    }

    public boolean fabricTasks(Class tasks, int number) {

        if (tasks.getClass().equals(Zuckerman.class)) {
             Zuckerman zuckerman = new Zuckerman();
                   return  zuckerman.isVerify(number);
        }else if (tasks.getClass().equals(Niven.class)){
            Niven niven = new Niven();
            return niven.isVerify(number);
        }else if (tasks.getClass().equals(Lishler.class)){
            Lishler lishler = new Lishler();
            lishler.isVerify(number);
        }else if (tasks.getClass().equals(BestNumber.class)){
            BestNumber bestNumber = new BestNumber();
            bestNumber.isVerify(number);
        }else if (tasks.getClass().equals(HappyNumber.class)){
            HappyNumber happyNumber = new HappyNumber();
            happyNumber.isVerify(number);
        }else if (tasks.getClass().equals(Kita.class)){
            Kita kita = new Kita();
            kita.isVerify(number);
        }else if (tasks.getClass().equals(Kapricara.class)){
            Kapricara kapricara = new Kapricara();
            kapricara.isVerify(number);
        }else if (tasks.getClass().equals(KapricaraSquare.class)){
            KapricaraSquare kapricaraSquare = new KapricaraSquare();
            kapricaraSquare.isVerify(number);
        }else if (tasks.getClass().equals(Armstrong.class)){
            Armstrong armstrong = new Armstrong();
            armstrong.isVerify(number);
        }else if(tasks.getClass().equals(FriendsNumber.class)){
            FriendsNumber friendsNumber = new FriendsNumber();
            friendsNumber.isVerify(number);
        }
        return false;
    }

    public static int mirrorNumber(int number) {
        int newNumber;
        String numberString = Integer.toString(number);
        StringBuilder newMirrorNumberString = new StringBuilder();

        for (int i = numberString.length() - 1; 0 <= i; i--) {
            newMirrorNumberString.append(numberString.charAt(i));
        }

        newNumber = Integer.parseInt(String.valueOf(newMirrorNumberString));

        return newNumber;
    }

    public static boolean simpleNumber(int value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }

        }
        return true;
    }

    public static Map<Integer, Integer> getMapWithSimpleNumberForBiggestValue(int value) {
        Map<Integer, Integer> simpleNumberWithThemCount = new HashMap<>();
        Integer countSimpleNumber = 0;
        if (value < BaseFunction.mirrorNumber(value)) {
            value = BaseFunction.mirrorNumber(value);
        }
        for (int i = 2; i <= value; i++) {

            if (BaseFunction.simpleNumber(i)) {
                countSimpleNumber++;
                simpleNumberWithThemCount.put(i, countSimpleNumber);
            }

        }
        return simpleNumberWithThemCount;
    }

    public static int getResultAdditionElementsNumber(int value) {
        int[] digits = Numeral.getDigits(value);
        return Array.additionItems(digits);
    }

    public static int getResultMultiplicationElementsNumber(int value) {
        int[] digits = Numeral.getDigits(value);
        return Array.multiplicationItems(digits);
    }

    public static boolean valueIsPalindrome(int value) {
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
