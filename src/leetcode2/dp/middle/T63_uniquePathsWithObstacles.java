package leetcode2.dp.middle;

public class T63_uniquePathsWithObstacles {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * */
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean findObstacle = false;
        //处理第一列
        for (int i=0; i<obstacleGrid.length; i++) {
            if (!findObstacle && obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                findObstacle = true;
                dp[i][0] = 0;
            }
        }
        findObstacle = false;
        //处理第一行
        for (int j=0; j<obstacleGrid[0].length; j++) {
            if (!findObstacle && obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                findObstacle = true;
                dp[0][j] = 0;
            }
        }
        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int paths = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(paths);
    }
}
