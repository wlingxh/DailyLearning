package com.wwh.demo.data.structure.array;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] arr = new int[5][4];
        arr[1][2] = 1;
        arr[2][3] = 2;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(String.format("%d\t", arr[i][j]));
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        int[][] sparseArray = new int[sum + 1][3];
        int row = arr.length;
        int col = arr[0].length;
        sparseArray[0][0] = row;
        sparseArray[0][1] = col;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = arr[i][j];
                }
            }
        }
        System.out.println("------------------------");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.print(String.format("%d\t", sparseArray[i][j]));
            }
            System.out.println();
        }


    }
}
