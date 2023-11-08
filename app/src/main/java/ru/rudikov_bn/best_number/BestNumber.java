package ru.rudikov_bn.best_number;

import java.util.HashMap;
import java.util.Map;

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.baseFunction.BaseFunction;

//Разработать программу для доказательства того, что 73 – это лучшее число. Число 73 считается лучшим числом, поскольку одновременное соответствует
//следующим условиям:
//- это 21 по порядку простое число
//- зеркально отраженное число 37 тоже простое, и при этом оно 12 по порядку, т.е.
//зеркально отраженное 21
//- если умножить 7 и 3, то получится 21
//- в бинарном виде 73 = 1001001, что является палиндромом
public class BestNumber implements Tasks {
    public static boolean isVerify(int value) {
        return startLogic(value);
    }

    public static boolean startLogic(int value){
         if (!checkToSimpleNumberAndHisMirrorNumber(value)
            || !checkToValueMirrorHasCountNumberMirror(value)
            || !numberInBinaryCodingIsPalindrome(value)){

            return false;
        }

        return true;
    }

    private static boolean checkToSimpleNumberAndHisMirrorNumber(int value){
        if (!BaseFunction.simpleNumber(value)){
            return false;
        } else {
            if (!BaseFunction.simpleNumber(BaseFunction.mirrorNumber(value))){
                return false;
            }
        }


        return true;
    }
    private static boolean checkToValueMirrorHasCountNumberMirror(int value){

        Map<Integer, Integer> mapWithAllSimpleNumberForAss = BaseFunction.getMapWithSimpleNumberForBiggestValue(value);

        if (!mapWithAllSimpleNumberForAss.isEmpty()) {
            int countValue = mapWithAllSimpleNumberForAss.get(Integer.valueOf(value));
            int countMirrorValue = mapWithAllSimpleNumberForAss.get(Integer.valueOf(BaseFunction.mirrorNumber(value)));

            if (countValue == BaseFunction.mirrorNumber(countMirrorValue) && countValue == BaseFunction.getResultMultiplicationElementsNumber(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean numberInBinaryCodingIsPalindrome(int value){
        String binaryString = Integer.toBinaryString(value);
        int binaryInt= Integer.parseInt(binaryString);
        return BaseFunction.valueIsPalindrome(binaryInt);
    }


}
