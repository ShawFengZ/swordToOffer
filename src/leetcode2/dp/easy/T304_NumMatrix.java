package leetcode2.dp.easy;

import leetcode2.dp.utils.NumMatrix;

public class T304_NumMatrix {
    /* *给定一个二维矩阵，计算其子矩形范围内元素的总和，
    * 该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
    **/
    public static void main(String[] args) {
        int[][] matrix = {
                /*{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}*/
        };
        int sum = 0;
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
