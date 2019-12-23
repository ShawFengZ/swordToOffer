package leetcode2.dp.middle;

public class T221_maximalSquare {
    /**
     * 最大正方形
     *
     * dp[i][j]是以(i, j)为右下角的区域所能构成的最大正方形的边长
     * 递推公式为：dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
     * */
    private static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=matrix.length; i++){
            for (int j=1; j<=matrix[0].length; j++) {
                if (matrix[i-1][j-1]=='1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1' ,'0' ,'1' ,'0' ,'0'},{'1' ,'0' ,'1' ,'1' ,'1'},
                {'1' ,'1' ,'1' ,'1' ,'1'},{'1' ,'0' ,'0' ,'1' ,'0'}};
        int maximalSquare = maximalSquare(matrix);
        System.out.println(maximalSquare);
    }
}
