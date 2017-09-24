package com.preparation.sorting;

import java.util.Arrays;

/**
 * Created by vlados on 9/25/2017.
 */
public class SelectionSort {

    public static void main(String[] args) {
        Integer[] array = {6, 2, 1, 7, 3, 11, 5};
        sort(array);
        System.out.println(Arrays.asList(array));
    }

    public static void sort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minValueIndex].compareTo(array[j]) > 0) {
                    minValueIndex = j;
                }
            }
            swap(array, i, minValueIndex);
        }
    }

    private static void swap(Integer[] array, int currentIndex, int newIndex) {
        int elementToSwap = array[currentIndex];
        array[currentIndex] = array[newIndex];
        array[newIndex] = elementToSwap;
    }
}
