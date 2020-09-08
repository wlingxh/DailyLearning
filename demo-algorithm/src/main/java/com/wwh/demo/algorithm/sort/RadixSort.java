package com.wwh.demo.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
//        int[] arr = {2, 34, 152, 10, 543, 453, 2, 47, 58};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        System.out.println("开始排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        sort(arr);
        System.out.println("结束排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
//        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[][] bucketArr = new int[10][arr.length];
        int[] temp = new int[10];

        //假设最大值为第一位,选出最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //计算出循环次数
        int count = (max + "").length();
        for (int i = 0, n = 1; i < count; i++, n *= 10) {
            //每轮循环中，将数组中的值 /n % 10，放入bucketArr二维数组中
            for (int j = 0; j < arr.length; j++) {
                //计算出数组中每个值
                int index = arr[j] / n % 10;
                bucketArr[index][temp[index]] = arr[j];
                temp[index]++;
            }
            int index = 0;
            for (int k = 0; k < temp.length; k++) {
                if (temp[k] != 0) {
                    for (int m = 0; m < temp[k]; m++) {
                        arr[index] = bucketArr[k][m];
                        index++;
                    }
                    temp[k] = 0;
                }
            }
        }
    }
}
