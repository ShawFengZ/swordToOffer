package leetcode2.twoPointers.middle;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class T287_findDuplicate {
    /*
   *
     * 寻找重复数
     *
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
     * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     *
     * 方法一：使用set, 时间消耗大
     * 方法二：
     *      1. 将数组看成链表，相当于找链表的环的入口，使用快慢指针
     * */
    private static int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
     }

     private static int findDuplicate2(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                fast = 0;
                while (nums[fast] != nums[slow]) {
                    fast = nums[nums[fast]];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
     }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        int duplicate = findDuplicate2(nums);
        System.out.println(duplicate);
    }
}
