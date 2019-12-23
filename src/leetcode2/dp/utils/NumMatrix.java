package leetcode2.dp.utils;

public class NumMatrix {

    private int[][] dp;//dp[i][j]代表以(0,0)-(i,j)包括的矩形的数字和
    private int[][] matrix;
    public NumMatrix(int[][] matrixs) {
        if (matrixs == null || matrixs.length == 0){
            return;
        }
        this.matrix = matrixs;
        dp = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[0][0];
                } else if (i == 0) {//第一行
                    dp[i][j] = dp[i][j-1] + matrix[i][j];
                } else if (j == 0) {//第一列
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = dp[i][j-1] + matrix[i][j];
                }
            }
        }
        for (int j=0; j<dp[0].length; j++) {
            for (int i=1; i<dp.length; i++) {
                dp[i][j] = dp[i][j] + dp[i-1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp == null || dp.length == 0) {
            return 0;
        }
        int area1 = 0;
        int area2 = 0;
        int area3 = 0;
        if (row1 > 0) {
            area1 = dp[row1-1][col2];
        }
        if (col1 > 0) {
            area2 = dp[row2][col1-1];
        }
        if (row1 > 0 && col1 > 0) {
            area3 = dp[row1-1][col1-1];
        }
        return dp[row2][col2]-area1-area2+area3;
    }
}
