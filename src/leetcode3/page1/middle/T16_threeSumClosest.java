package leetcode3.page1.middle;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

public class T16_threeSumClosest {
    /**
     * 最接近的三数之和
     * */
    private static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i=0; i<nums.length-2; i++) {
            int sum = 0;
            int l = i+1, h = nums.length-1;
            while (l < h) {
                sum = nums[i] + nums[l]+ nums[h];
                int tmp = Math.abs(sum-target);
                if (tmp < min) {
                    min = tmp;
                    minSum = sum;
                }
                if (tmp == 0) {
                    return target;
                } else if (sum < target) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 1, 55};
        int i = threeSumClosest(nums, 3);
        System.out.println(i);
    }
}
