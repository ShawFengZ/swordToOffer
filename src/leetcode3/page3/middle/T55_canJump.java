package leetcode3.page3.middle;

public class T55_canJump {

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int steps = 0, reach = 0, nextReach = nums[0];
        for(int i=0; i<nums.length-1; i++) {
            nextReach = Math.max(nextReach, nums[i] + i);
            if (nextReach >= nums.length - 1) {
                steps++;
                return true;
            }
            if (i == reach) {
                reach = nextReach;
            }
        }
        return nextReach>=nums.length-1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        boolean jump = canJump(nums);
        System.out.println(jump);
    }
}
