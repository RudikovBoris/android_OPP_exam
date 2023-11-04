package ru.rudikov_bn.array;

public class Array {

    public static int multiplicationItems(int[] items) {
        final int size = items.length;
        int r = 1;
        for (int i = 0; i < size; ++i) {
            r *= items[i];
        }
        return r;
    }
    
}
