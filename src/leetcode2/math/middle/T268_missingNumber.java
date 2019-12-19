package leetcode2.math.middle;

import java.util.HashSet;
import java.util.Set;

public class T268_missingNumber {
    /**
     * 缺失数字
     *
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     *
     * 方法一：暴力法，使用一个Set即可
     * 方法二：1^1^2^2^3=3
     * 方法三：求和
     * */
    private static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<=nums.length; i++) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }
        return (int)set.toArray()[0];
    }

    private static int missingNumber2(int[] nums){
        int res = nums.length;
        for (int i=0; i<nums.length; ++i) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int number = missingNumber2(nums);
        System.out.println(number);
    }
}