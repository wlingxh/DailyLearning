package com.wwh.demo.algorithm.search;

/**
 * 二分查找算法
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 2, 2 , 5, 6};
        int index = search(arr, 2, 0, arr.length - 1);
//        System.out.println(index);
    }

    public static int search(int[] arr, int findValue, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (findValue > arr[mid]) {
            return search(arr, findValue, mid + 1, right);
        } else if (findValue < arr[mid]) {
            return search(arr, findValue, left, mid - 1);
        } else {
            System.out.println(mid);
            int l = mid - 1;
            while (true) {
                if (l < 0 || arr[l] != findValue) {
                    break;
                }
                System.out.println(l);
                l--;
            }
            int r = mid + 1;
            while (true) {
                if (r > right || arr[r] != findValue) {
                    break;
                }
                System.out.println(r);
                r++;
            }
            return mid;
        }
    }
}
