package com.preparation.sorting;

import java.util.Arrays;

/**
 * Created by vlados on 9/25/2017.
 */
public class MergeSort {
    public static void main(String[] args) {
        Integer[] array = {6, 2, 1, 7, 3, 11, 5};
        sort(array);
        System.out.println(Arrays.asList(array));
    }

    public static void sort(Integer[] array) {
        if(array.length <= 1) {
            return;
        }

        int halfArray = array.length / 2;
        Integer[] leftArray = new Integer[halfArray];
        System.arraycopy(array, 0, leftArray, 0, halfArray);
        sort(leftArray);

        int rightSize = array.length - halfArray;
        Integer[] rightArray = new Integer[rightSize];
        System.arraycopy(array, halfArray, rightArray, 0, rightSize);
        sort(rightArray);
        merge(array, leftArray, rightArray);
    }

    private static void merge(Integer[] array, Integer[] leftArray, Integer[] rightArray) {
        int arrayIndex = 0;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if (rightArray[rightArrayIndex] > leftArray[leftArrayIndex]) {
                array[arrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                array[arrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }

            arrayIndex++;
        }

        while (leftArrayIndex < leftArray.length) {
            array[arrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            arrayIndex++;
        }

        while (rightArrayIndex < rightArray.length) {
            array[arrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            arrayIndex++;
        }

    }
}
