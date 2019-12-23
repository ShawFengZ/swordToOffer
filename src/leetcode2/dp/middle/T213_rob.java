package leetcode2.dp.middle;

public class T213_rob {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 分为两种情况，偷第一间和不偷第一间
     * */
    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int maxOfBefore = 0, maxPre = 0, curMax = 0;
        int maxOfBeforeN0 = 0, maxPreN0=0, curMaxN0 = 0;
        int maxProfit = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (i != 0) {
                curMaxN0 = Math.max(maxPreN0, maxOfBeforeN0+nums[i]);
                if (maxProfit < curMaxN0) {
                    maxProfit = curMaxN0;
                }
                maxOfBeforeN0 = Math.max(maxOfBeforeN0, maxPreN0);
                maxPreN0 = curMaxN0;
            }
            if (i != nums.length-1) {
                curMax = Math.max(maxPre, maxOfBefore+nums[i]);
                if (maxProfit < curMax) {
                    maxProfit = curMax;
                }
                maxOfBefore = Math.max(maxOfBefore, maxPre);
                maxPre = curMax;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int rob = rob(nums);
        System.out.println(rob);
    }
}
