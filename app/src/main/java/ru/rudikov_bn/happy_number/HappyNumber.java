package ru.rudikov_bn.happy_number;

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.number.Numeral;


//Разработать программу для поиска "счастливых" чисел в запрашиваемом диапазоне.
// "Счастливое" число – это натуральное число, которое в ходе определенных действий преобразуется к единице
//        Например:
//        Число "7" является счастливым числом, т.к.:
//        7^2=49
//        4^2+9^2=97
//        9^2+7^2=130
//        1^2+3^2+0^2=10
//        1^2+0^2=1
public class HappyNumber implements Tasks {


    public boolean isVerify(int value) {
        Integer countSteps = 0;
        return happyNumberLogic(value, countSteps);
    }

    private static boolean happyNumberLogic(int value, Integer countSteps) {
        countSteps++;
        int[] digits = Numeral.getDigits(value);
        int newValue = 0;
        for (int oneElement : digits) {
            newValue += oneElement * oneElement;
        }

        if (countSteps <= 7) {
            return happyNumberLogic(newValue, countSteps);
        }

        return newValue == 1;

    }

}
