package com.wwh.demo.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80000);
        }
        System.out.println("开始排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("结束排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
    }

    private static int[] sort(int[] array) {
        //认为数组第一位是有序的，从第2位开始
        for (int i = 1; i < array.length; i++) {
            //将array【i】的数赋值
            int temp = array[i];
            int j = i;
            //循环结束条件：j=0时；
            //循环开始
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            //如果不相等，交换
            if (j != i) {
                array[j] = temp;
            }
        }

        return array;
    }

}
