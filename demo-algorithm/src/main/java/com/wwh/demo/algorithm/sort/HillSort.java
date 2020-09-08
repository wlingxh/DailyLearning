package com.wwh.demo.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 希尔排序
 */
public class HillSort {

    public static void main(String[] args) {
        int[] array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80000);
        }
        System.out.println("开始排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        //希尔排序 1：移位法（快）记这种
        // 开始排序：2020-09-08 11:20:59:366
        //结束排序：2020-09-08 11:20:59:386
        sort(array);
        //希尔排序 2：交换法 （慢）
        // 开始排序：2020-09-08 11:21:50:248
        //结束排序：2020-09-08 11:21:58:325
//        shellSort(array);
//        System.out.println(Arrays.toString(array));
        System.out.println("结束排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
    }

    private static int[] sort(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            gap = gap * 3 + 1;
        }
        //增量gap
        while (gap > 0) {
            //[gap,array.length]区间的数组
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i - gap;
                //{1，3，2，4，5}
                while (j >= 0 && array[j] > temp) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return array;
    }

    private static int[] shellSort(int[] array) {
        //gap:步长
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            //对一个步长区间进行比较 [gap,array.length)
            for (int i = gap; i < array.length; i++) {
                //对步长区间中具体的元素进行比较
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        int temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
//                System.out.println("gap=" + gap + "---->" + Arrays.toString(array));
            }

        }
        return array;
    }


}
