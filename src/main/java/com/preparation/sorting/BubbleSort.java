package com.preparation.sorting;

import java.util.Arrays;

/**
 * Created by vlados on 9/25/2017.
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] array = {6, 2, 1, 7, 3, 11, 5};
        sort(array);
        System.out.println(Arrays.asList(array));
    }

    public static void sort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int nextItemIndex = j + 1;
                if (array[j].compareTo(array[nextItemIndex]) > 0) {
                    swap(array, j, nextItemIndex);
                }
            }
        }
    }

    private static void swap(Integer[] array, int currentIndex, int newIndex) {
        int elementToSwap = array[currentIndex];
        array[currentIndex] = array[newIndex];
        array[newIndex] = elementToSwap;
    }
}
