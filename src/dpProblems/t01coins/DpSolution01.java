package dpProblems.t01coins;

/**
 * @author zxf
 * @date 2018/12/7 9:51
 */
public class DpSolution01 {
    /**
     * 题目描述：
     *      假设有几种硬币，如1、3、5，并且数量无限。请找出能够组成某个数目的找零所使用最少的硬币数。
     * 解法一：贪婪，尽量找数值为5的硬币
     * 解法二：dp
     *      1. 0元对应0，1元对应1，2元对应2，3元对应1，4元对应2，5元对应1
     *      2. 当n>5时，dp[n]=min(dp[n-1]+1, dp[n-3]+1, dp[n-5]+1)
     *      dp的思想就是从前一个最佳状态到后一个最佳状态
     *
     *      统一解法：
     *      1. 定义一个数组coin[]存放硬币的种类
     *      2. dp[n] = min(dp[n-coin[0], dp[n-coin[1]], ..., dp[n-coin[n]])+1
     * */
    public static int countCoins(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 1;
        if (n <= 5)
            return dp[n];
        for (int i = 6; i <= n; i++) {
            int min = Math.min(dp[i-1] + 1, dp[i-3] + 1);
            min = Math.min(min, dp[i-5]+1);
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countCoins(10));
    }
}
