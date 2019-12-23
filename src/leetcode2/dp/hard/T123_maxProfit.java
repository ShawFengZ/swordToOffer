package leetcode2.dp.hard;

public class T123_maxProfit {
    /**
     * 买卖股票的最佳时机
     *
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *
     * 对于任意一天考虑四个变量:
     *         fstBuy: 在该天第一次买入股票可获得的最大收益
     *         fstSell: 在该天第一次卖出股票可获得的最大收益
     *         secBuy: 在该天第二次买入股票可获得的最大收益
     *         secSell: 在该天第二次卖出股票可获得的最大收益
     *         分别对四个变量进行相应的更新, 最后secSell就是最大
     *         收益值(secSell >= fstSell)
     * */
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 2) {
            return 0;
        }
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for (int price: prices) {
            fstBuy = Math.max(fstBuy, -price);
            fstSell = Math.max(fstSell, fstBuy+price);
            secBuy = Math.max(secBuy, fstSell-price);
            secSell = Math.max(secSell, secBuy+price);
        }
        return secSell;
    }
}
