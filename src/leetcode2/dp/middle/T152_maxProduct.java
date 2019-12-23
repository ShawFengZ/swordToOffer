package leetcode2.dp.middle;

import sun.nio.cs.ext.MacThai;

public class T152_maxProduct {
    /**
     * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     * */
    private static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE, curMax = 1, curMin = 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(nums[i], curMax*nums[i]);
            curMin = Math.min(nums[i], curMin*nums[i]);

            max = Math.max(curMax, max);
        }
        return max;
    }
}
