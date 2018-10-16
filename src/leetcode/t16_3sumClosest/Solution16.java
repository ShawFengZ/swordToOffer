package leetcode.t16_3sumClosest;

import java.util.Arrays;

/**
 * @author zxf
 * @date 2018/10/16 9:43
 */
public class Solution16 {
    /**
     * 给定一个数组和一个目标值，找到数组中的三个数，使得那3个数的和与目标最接近,返回求到的三个数的和
     * 思路:
     *      1. 对数组进行排序。
     *      2. 作为3sum一样向中间求值，每次求值都减去target，如果绝对值更小，保存这个绝对值
     *      3. 遍历完成后返回该数组
     * */
    public static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i=0; i<nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum-target) < Math.abs(min)) {
                    min = Math.abs(sum-target);
                    minSum = sum;
                }
                /*while (left < right && nums[left] == nums[left+1])
                    left++;
                while (left < right && nums[right] == nums[right-1])
                    right--;*/
                if (left < right && sum - target < 0)
                    left++;
                else if (left < right && sum - target > 0)
                    right--;
                else if (left < right && sum - target == 0)
                    break;
            }
        }
        return minSum;
    }
}
