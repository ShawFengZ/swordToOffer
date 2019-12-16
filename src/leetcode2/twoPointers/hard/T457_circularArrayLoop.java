package leetcode2.twoPointers.hard;

public class T457_circularArrayLoop {
    /**
     * 环形数组循环：
     * 1. 快慢指针， slow = nums[slow], fast = nums[nums[fast]];
     * 2. 如果相遇则有环，如果越界则无环
     * */
    private static boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            fast = nums[fast+nums[fast]];
            fast = nums[fast+nums[fast]];
            slow = nums[slow+nums[slow]];
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2};
        boolean b = circularArrayLoop(nums);
        System.out.println(b);
    }
}
