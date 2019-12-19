package leetcode2.hashTable.easy;

import java.util.HashMap;
import java.util.Map;

public class T219_containsNearbyDuplicate {
    /**
     * 存在重复数字II
     *
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
     * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     * */
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        boolean b = containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }
}
