package com.wwh.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {0, 2, 2, 4, 4};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int left, int right) {
        //左
        int l = left;
        //右
        int r = right;
        int pivot = array[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (array[l] < pivot) {
                l += 1;
            }
            while (array[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }

            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            if (array[l] == pivot) {
                r -= 1;
            }
            if (array[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            sort(array, left, r);
        }
        if ((right > l)) {
            sort(array, l, right);
        }
    }
}
