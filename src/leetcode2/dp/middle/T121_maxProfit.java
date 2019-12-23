package leetcode2.dp.middle;

public class T121_maxProfit {
    /**
     * 买卖股票的最佳时机
     *
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个
     * 算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     *
     * dp[i]代表第i天的最大收益，dp[i] = max(dp[i-1], price[i]-min(price(0,i-1)))
     * */
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i=1; i<dp.length; i++) {
            dp[i] = Math.max(prices[i]-min, dp[i-1]);
            if (prices[i] < min) {
                min = prices[i];
            }
            if (maxProfit < dp[i]) {
                maxProfit = dp[i];
            }
        }
        return maxProfit;
    }

    //对上面的优化
    private static int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int curProfit = 0;
        int nextProfit = 0;
        int min = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i=1; i<prices.length; i++) {
            nextProfit = Math.max(prices[i]-min, curProfit);
            if (prices[i] < min) {
                min = prices[i];
            }
            if (maxProfit < nextProfit) {
                maxProfit = nextProfit;
            }
            curProfit  = nextProfit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int maxProfit = maxProfit2(prices);
        System.out.println(maxProfit);
    }
}
