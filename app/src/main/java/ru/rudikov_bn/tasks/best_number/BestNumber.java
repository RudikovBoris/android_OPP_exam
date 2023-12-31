package ru.rudikov_bn.tasks.best_number;

import java.util.Map;

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.base_function.BaseFunction;

//Разработать программу для доказательства того, что 73 – это лучшее число. Число 73 считается лучшим числом, поскольку одновременное соответствует
//следующим условиям:
//- это 21 по порядку простое число
//- зеркально отраженное число 37 тоже простое, и при этом оно 12 по порядку, т.е.
//зеркально отраженное 21
//- если умножить 7 и 3, то получится 21
//- в бинарном виде 73 = 1001001, что является палиндромом
public class BestNumber implements Tasks {

    public boolean isVerify(int value) {
        return startLogic(value);
    }

    private static boolean startLogic(int value) {
        return checkToSimpleNumberAndHisMirrorNumber(value)
                && checkToValueMirrorHasCountNumberMirror(value)
                && numberInBinaryCodingIsPalindrome(value);
    }

    private static boolean checkToSimpleNumberAndHisMirrorNumber(int value) {
        if (!BaseFunction.simpleNumber(value)) {
            return false;
        } else {
            return !BaseFunction.simpleNumber(BaseFunction.mirrorNumber(value));
        }
    }

    private static boolean checkToValueMirrorHasCountNumberMirror(int value) {

        Map<Integer, Integer> mapWithAllSimpleNumberForAss = BaseFunction.getMapWithSimpleNumberForBiggestValue(value);

            if (!mapWithAllSimpleNumberForAss.isEmpty()
                    && mapWithAllSimpleNumberForAss.containsKey(value)
                    && mapWithAllSimpleNumberForAss.containsKey(BaseFunction.mirrorNumber(value))) {
                Integer countValueInteger = mapWithAllSimpleNumberForAss.get(value);
                Integer countMirrorValueInteger = mapWithAllSimpleNumberForAss.get(BaseFunction.mirrorNumber(value));
                if (countMirrorValueInteger != null && countValueInteger != null) {
                    int countValue = countValueInteger;
                    int countMirrorValue = countMirrorValueInteger;

                    return (countValue == BaseFunction.mirrorNumber(countMirrorValue)
                            && countValue == BaseFunction.getResultMultiplicationElementsNumber(value));
                }
            }
        return false;
    }

    private static boolean numberInBinaryCodingIsPalindrome(int value) {
        String binaryString = Integer.toBinaryString(value);
        int binaryInt = Integer.parseInt(binaryString);
        return BaseFunction.valueIsPalindrome(binaryInt);
    }


}
