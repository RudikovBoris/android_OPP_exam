package ru.rudikov_bn.array;

public final class Array {
    private Array() {
    }

    public static int multiplicationItems(int[] items) {
        int result = 1;
        for (int oneElementItems : items) {
            result *= oneElementItems;
        }
        return result;
    }

    public static int additionItems(int[] items) {
        int result = 1;
        for (int oneElementItems : items) {
            result += oneElementItems;
        }
        return result;
    }

}
