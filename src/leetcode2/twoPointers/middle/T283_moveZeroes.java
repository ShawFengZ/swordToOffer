package leetcode2.twoPointers.middle;

public class T283_moveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 方法一的双指针法很慢
     * 方法二：
     *  1. 将不为0的数字往前移，最后记录index;
     *  2. index后的数字全部设置为0；
     * */
    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int low = 0;
        int high = nums.length-1;
        while (high >= 0 && nums[high] == 0) {
            high--;
        }
        while (low < high) {
            if (nums[high] == 0) {
                high--;
                continue;
            }
            if (nums[low] != 0) {
                low++;
                continue;
            }
            for (int i=low; i<high; i++) {
                nums[i] = nums[i+1];
            }
            nums[high] = 0;
        }

        for (int i: nums)
            System.out.print(i + " ");
    }

    private static void moveZeros(int[] nums){
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
