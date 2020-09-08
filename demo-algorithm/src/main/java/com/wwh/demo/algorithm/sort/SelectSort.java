package com.wwh.demo.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort {

    private static int[] sort(int[] array) {
        //{2，1，3}
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < array.length - 1; i++) {
            //假设m为最小值下标
            int m = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < array.length; j++) {
                if (array[m] > array[j]) {
                    // 记录目前能找到的最小值元素的下标
                    m = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (m != i) {
                int temp = array[i];
                array[i] = array[m];
                array[m] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80000);
        }
        System.out.println("开始排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        sort(array);
//        shellSort(array);
//        System.out.println(Arrays.toString(array));
        System.out.println("结束排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
