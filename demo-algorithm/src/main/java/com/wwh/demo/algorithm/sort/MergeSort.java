package com.wwh.demo.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80000);
        }
        System.out.println("开始排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        //归并排序实现1：尚硅谷教的（快）记忆
        //开始排序：2020-09-08 11:18:01:966
        //结束排序：2020-09-08 11:18:01:986
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
//        System.out.println(Arrays.toString(array));
        //归并排序实现2： 程序员小吴 （慢）
        // 开始排序：2020-09-08 11:19:17:459
        // 结束排序：2020-09-08 11:19:19:295
//        sort(array);
        System.out.println("结束排序：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));

    }
    //分
    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
    //知
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[t] = arr[l];
                l++;
                t++;
            } else {
                temp[t] = arr[r];
                r++;
                t++;
            }
        }
        //当l<=mid说明，右边的数组已经排序完
        while (l <= mid) {
            temp[t] = arr[l];
            l++;
            t++;
        }
        while (r <= right) {
            temp[t] = arr[r];
            r++;
            t++;
        }
        //将临时数组中的元素赋值到arr数组中
        int tempLeft = left;
        for (int i = 0; i < t; i++) {
            arr[tempLeft] = temp[i];
            tempLeft++;
        }
        //数据比较放入temp数组中后
//        t = 0;
//        int tempLeft = left;
//        while (tempLeft <= right) {
//            arr[tempLeft] = temp[t];
//            t++;
//            tempLeft++;
//        }
    }

    public static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                res[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                res[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            res[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            res[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return res;
    }

    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length < 2) {
            return arr;
        }
        int mid = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(sort(left), sort(right));
    }

}
