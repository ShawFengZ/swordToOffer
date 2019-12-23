package leetcode2.dp.middle;

public class T198_rob {
    /**
     * 打家劫舍，不能打劫相邻的房屋
     *
     * 动态规划
     * */
    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxOfBefore = 0, maxPre=0, maxCur = 0;
        int maxProfit = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            maxCur = Math.max(maxPre, maxOfBefore+nums[i]);
            if (maxCur > maxProfit) {
                maxProfit = maxCur;
            }
            maxOfBefore = Math.max(maxOfBefore, maxPre);
            maxPre = maxCur;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int rob = rob(nums);
        System.out.println(rob);
    }
}
