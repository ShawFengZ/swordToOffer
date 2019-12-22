package leetcode2.dp.hard;

public class T53_maxSubArray {
    /**
     * 思路：
     * 1.
     * */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num: nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

}
