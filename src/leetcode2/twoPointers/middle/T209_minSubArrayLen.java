package leetcode2.twoPointers.middle;

import com.sun.org.apache.regexp.internal.RE;

public class T209_minSubArrayLen {
    /**
     * 长度最小的子数组
     *
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，
     * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
     * 如果不存在符合条件的连续子数组，返回 0。
     *
     * 思路：
     * 1. 双指针pre, post, 如果之间的和小于s则pre++, 大于s则post++;
     * 2. 记录最小长度和字数组的起始位置
     * */
    private static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int pre=0, post=0;
        int sum = nums[0];
        if (sum > s) {
            return 1;
        }
        while (pre < nums.length && post <= pre) {
            if (sum < s) {
                pre++;
                if (pre == nums.length) {
                    break;
                }
                sum += nums[pre];
            } else if (sum >= s) {
                sum -= nums[post];
                post++;
            }
            if (sum >= s && minLen > pre-post+1) {
                minLen = pre - post+1;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 13};
        int i = minSubArrayLen(20, nums);
        System.out.println(i);
    }
}
