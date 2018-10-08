package book.t42_maxSumOfArray;

/**
 * @author zxf
 * @date 2018/10/8 14:33
 */
public class SolutionBook42 {
    /**
     * 题目描述：
     *      输入一个整型数组，数组中有整数也有负数。求数组中所有子数组的和的最大值。
     *      要求时间复杂度为O(n)
     * 解法1：
     *      1. 从前一个数字开始累加的和会小于当前数字，放弃之前的累加，从当前数字开始累加。
     *      2. 用一个数字记下最大和，如果出现更大的值，要更新。
     * */
    public static int findGreatestSumOfSubArray(int[] nums){
        if (nums == null)
            return -1;
        if (nums.length == 1)
            return nums[0];
        int maxSum=0, sum = 0;
        for (int i=0; i<nums.length; i++) {
            int num = sum + nums[i];
            if (num < nums[i]) {
                sum = nums[i];
                continue;
            }
            sum = num;
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
