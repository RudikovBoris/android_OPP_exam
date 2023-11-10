package ru.rudikov_bn.array;

public final class Array {
    private Array() {
    }

    public static int multiplicationItems(int[] items) {
        final int size = items.length;
        int result = 1;
        for (int i = 0; i < size; ++i) {
            result *= items[i];
        }
        return result;
    }

    public static int additionItems(int[] items) {
        final int size = items.length;
        int result = 1;
        for (int i = 0; i < size; ++i) {
            result += items[i];
        }
        return result;
    }

}
