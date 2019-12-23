package leetcode2.dp.hard;

public class T174_calculateMinimumHP {
    /**
     * 地下城游戏
     *
     * 定义dp[i][j]为走到i,j位置消耗的最少的能量
     * 则dp[i][j] = dungeon[i][j] + min(dp[i-1][j], dp[i][j-1])
     * */
    private static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int m = dungeon.length, n = dungeon[0].length;
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i==m-1 && j==n-1) {//终点
                    dp[i][j] = Math.max(1, 1-dungeon[i][j]);
                } else if (i == m-1) {//最后一行
                    dp[i][j] = Math.max(1, dp[i][j+1]-dungeon[i][j]);
                } else if (j == n-1) {//最后一列
                    dp[i][j] = Math.max(1, dp[i+1][j]-dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int i = calculateMinimumHP(dungeon);
        System.out.println(i);
    }
}
