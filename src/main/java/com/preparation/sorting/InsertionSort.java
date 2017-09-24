package com.preparation.sorting;

import java.util.Arrays;

/**
 * Created by vlados on 9/25/2017.
 */
public class InsertionSort {

    public static void main(String[] args) {
        Integer[] array = {6, 2, 1, 7, 3, 11, 5};
        sort(array);
        System.out.println(Arrays.asList(array));
    }

    public static void sort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int newIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[newIndex]) {
                    swap(array, newIndex, j);
                    newIndex = j;
                } else {
                    break;
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
