package leetcode2.dp.hard;

public class T115_numDistinct {
    /**
     * 不同的子序列
     *
     * 动态规划
     *
     * dp[i][j] 代表 T 前 i 字符串可以由 S j 字符串组成最多个数.
     *
     * 所以动态方程:
     *
     * 当 S[j] == T[i] , dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
     *
     * 当 S[j] != T[i] , dp[i][j] = dp[i][j-1]
     *
     * */
    private static int numDistinct(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[][] dp = new int[chars.length+1][chart.length+1];
        for (int i=0; i<=chars.length; i++) {
            dp[i][0] = 1;
        }
        for (int i=1; i<=chars.length; i++) {
            for (int j=1; j<=chart.length; j++) {
                dp[i][j] = dp[i-1][j];
                if (chars[i-1] == chart[j-1]) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[chars.length][chart.length];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int numDistinct = numDistinct(s, t);
        System.out.println(numDistinct);
    }
}
