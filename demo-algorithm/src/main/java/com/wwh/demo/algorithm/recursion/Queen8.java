package com.wwh.demo.algorithm.recursion;

import java.util.Arrays;

/**
 * 8皇后问题
 */
public class Queen8 {

    int maxSize;
    int[] array;
    int count = 0;

    public Queen8(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }
    /**
     * 打印
     */
    public void print() {
        count++;
        System.out.println(Arrays.toString(array));
    }
    /**
     * 判断第n个皇后
     *
     * @param n
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] ||
                    Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
    /**
     * 放置第n个皇后
     *
     * @param n
     */
    public void check(int n) {
        if (n == maxSize) {
            print();
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8(8);
        queen8.check(0);
        System.out.println(queen8.count);
    }


}
