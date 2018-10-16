package leetcode.t26_RemoveDuplicatesFromSortedArray;

/**
 * @author zxf
 * @date 2018/10/16 19:16
 */
public class Solution26 {
    /**
     * 题目描述：
     *      给定一个排序后的数组，返回排除重复元素后的数组的长度.
     *      题目要求要改变数组本身。
     * 思路：
     *      1. 遍历数组
     * */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num) {
                num = nums[i];
                nums[count]=num;
                count++;
            }
        }
        /*for (int i=0; i<count; i++) {
            System.out.print(nums[i] + " ");
        }*/
        return count;
    }

}
