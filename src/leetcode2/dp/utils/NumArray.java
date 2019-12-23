package leetcode2.dp.utils;

public class NumArray {

    private int[] nums;
    private int[] dp1;//从0到i的数的和
    private int[] dp2;//从最后一位到第一位的和
    private int sum = 0;
    public NumArray(int[] nums1) {
        this.nums = nums1;
        dp1 = new int[nums.length];
        dp2 = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            dp1[i] = sum;
        }
        for (int i=nums.length-1; i>=0; i--) {
            if (i == nums.length-1) {
                dp2[i] = nums[nums.length-1];
            } else {
                dp2[i] = dp2[i+1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sum-(dp1[i]+dp2[j])+(nums[i]+nums[j]);
    }
}
