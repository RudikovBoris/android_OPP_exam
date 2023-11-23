package ru.rudikov_bn.tasks.friends_number;

/*
 * Разработать программу для поиска дружественных чисел в указываемом диапазоне десятичной
 * системы счисления. Дружественные числа, это два различных натуральных числа, для которых
 * сумма всех собственных делителей первого числа равна второму числу и наоборот,
 * сумма всех собственных делителей второго числа равна первому числу.
 * Например, числа 220 и 284 являются дружественными, поскольку, для числа 220,
 * сумма собственных (т.е. кроме самого числа) делителей равна 284,
 * т.е. 1 + 2 + 4 + 5 + 10 + 11 + 20 + 22 + 44 + 55 + 110 = 284,
 * а для числа 284 - равна 220, т.е. 1 + 2 + 4 + 71 + 142 = 220.
 */

import java.util.ArrayList;

import ru.rudikov_bn.Tasks;

public class FriendsNumber implements Tasks {


    public boolean isVerify(int value) {
        int firstFriend = foundFriend(value);
        int secondFriends = foundFriend(firstFriend);

        return value == secondFriends;
    }

    private int foundFriend(int value) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int result = 1; result < value; result++) {
            if (value % result == 0) {
                arrayList.add(result);
            }

        }
        int result = 0;
        for (Integer oneElement : arrayList) {
            result += oneElement;
        }
        return result;
    }
}
