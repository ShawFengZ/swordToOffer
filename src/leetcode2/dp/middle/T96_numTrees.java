package leetcode2.dp.middle;

public class T96_numTrees {
    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * 动态规划
     * dp[i]代表i个节点组成的二叉树个数
     * dp[0] = 1;
     * dp[i] = (dp[0]*dp[i-1] + dp[1]*[i-2] + dp[2][i-3] + ...+ dp[j-1]*dp[i-j] + dp[i-1][0]
     * */
    private static int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = numTrees(3);
        System.out.println(i);
    }
}
