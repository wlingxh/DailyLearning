package com.wwh.demo.algorithm.sort;

/**
 *冒泡排序
 */
public class BubbleSort {

    private static int[] sort(int[] array) {
        //外层循环：表示进行了几轮
        for (int i = 0; i < array.length - 1; i++) {
            //内层循环：表示每轮进行几次比较
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 8, 9, 0};
        array = sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

}
