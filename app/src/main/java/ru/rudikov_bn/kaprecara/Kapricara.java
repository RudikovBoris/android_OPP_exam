package ru.rudikov_bn.kaprecara;

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.number.Numeral;

/**
 * Разработать программу для доказательства постоянной Капрекара 6174. Число 6174 называется постоянной Капрекара, поскольку имеет следующую особенность:
 * 1) выбрать любое четырёхзначное число больше 1000, в котором не все цифры одинаковы;
 * 2) расположить цифры сначала в порядке возрастания, затем в порядке убывания;
 * 3) вычесть из большего меньшее (производя перестановки цифр и вычитания, нули следует сохранять);
 * 4) повторить пп. 2-3, до тех пор, пока не получится число 6174
 * 5) выполнить такие действия для каждого 4-х значного числа (см. условия в п. 1) (отметить, что на получение числа 6174, всегда требуется не более 7 шагов)
 * <p>
 * Например:
 * <p>
 * Число 3412:
 * 4321 − 1234 = 3087
 * 8730 − 378 = 8352
 * 8532 − 2358 = 6174;
 * <p>
 * Число 1100:
 * 1100 − 11 = 1089
 * 9810 − 189 = 9621
 * 9621 − 1269 = 8352
 * 8532 − 2358 = 6174.
 * <p>
 * Число 6174:
 * 7641 − 1467 = 6174.
 */
public class Kapricara implements Tasks {

    public boolean isVerify(int value) {

        for (int iteratorSteps = 0; iteratorSteps < 7; iteratorSteps++) {
            value = logicKapricara(value);
            if (value == 6174) {
                return true;
            }
        }
        return false;
    }

    public static int logicKapricara(int value) {
        int[] digits = Numeral.getDigits(value);
        StringBuilder stringBuilder = bubbleSorting(digits);
        String correctPlaceElement = String.valueOf(stringBuilder);
        String reversePlaceElement = String.valueOf(stringBuilder.reverse());


        return Integer.parseInt(reversePlaceElement) - Integer.parseInt(correctPlaceElement);
    }

    private static StringBuilder bubbleSorting(int[] value) {
        int templeVariable;
        for (int baseIterator = 0; baseIterator < value.length; baseIterator++) {
            for (int i = 0; i < value.length - 1; i++) {
                if (value[i] > value[i + 1]) {
                    templeVariable = value[i + 1];
                    value[i + 1] = value[i];
                    value[i] = templeVariable;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int oneElement : value) {
            stringBuilder.append(oneElement);
        }
        return stringBuilder;
    }
}
