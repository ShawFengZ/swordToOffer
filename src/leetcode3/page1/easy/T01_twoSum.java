package leetcode3.page1.easy;

import java.util.Arrays;
import java.util.HashMap;

public class T01_twoSum {
    /**
     * 两数之和
     * */
    private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            map.put(target-nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = twoSum(nums, target);
        for (int i: twoSum) {
            System.out.print(i + " ");
        }
    }
}
