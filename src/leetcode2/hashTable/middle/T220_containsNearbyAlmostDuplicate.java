package leetcode2.hashTable.middle;

import java.util.HashMap;
import java.util.Map;

public class T220_containsNearbyAlmostDuplicate {
    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j]
     *  的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     * */
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int key1 = nums[i] - t;

        }
        return false;
    }
}
