package leetcode2.hashTable.easy;

public class T136_singleNumber {
    /**
     * 方法一：哈希表
     * 方法二：^
     * */
    private static int singleNumber(int[] nums) {
        if (nums == null || nums.length % 2 == 0 || nums.length == 0) {
            return -1;
        }
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

}
