package leetcode2.dp.middle;

import java.util.Arrays;

public class T322_coinChange {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所
     * 需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * 方法一：贪心算法(求不出解的)
     * 方法二：dp
     * */
    private static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        int cnt = 0;
        int index = coins.length-1;
        while (index>=0 && amount > 0) {
            cnt += amount/coins[index];
            amount %= coins[index];
            index--;
        }
        return amount>0?-1:cnt;
    }

    /**
     * dp做法
     * dp[j]代表钱包总价值为j时，需要的最少硬币数
     *
     * */
    private static int coinChange2(int[] coins, int amount) {
        if (coins==null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        for (int i=0; i<coins.length; i++) {
            for (int j=coins[i]; j<= amount; j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    /**
     * dfs+剪枝，快于dp
     * 最优解法
     * */
    private static int minCount = Integer.MAX_VALUE;
    private static int coinChange3(int[] coins, int amount){
        Arrays.sort(coins);
        recursion(coins, amount, 0, coins.length-1);
        return minCount==Integer.MAX_VALUE?-1:minCount;
    }

    private static void recursion(int[] coins, int amount, int count, int index){
        if (index < 0 || count+amount/coins[index] >= minCount) {
            return;
        }
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount/coins[index]);
            return;
        }
        for (int i=amount/coins[index]; i>=0; i--) {
            recursion(coins, amount-i*coins[index], count+i, index-1);
        }
    }

    /**
     * [186,419,83,408]
     * 6249
     * */
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;

        int change3 = coinChange3(coins, amount);
        System.out.println(change3);
        //int cnt = coinChange(coins, amount);
        //System.out.println(cnt);
    }
}
