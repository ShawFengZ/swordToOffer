package leetcode.t27_removeElement;

/**
 * @author zxf
 * @date 2018/10/16 19:30
 */
public class Solution27 {
    /**
     * 题目描述：
     *      给定一个数组，和一个目标值，删除该数组中该目标的元素，返回剩余数组的长度。
     *      要修改数组。
     * 思路：
     *      1. 遍历数组，找该数组中的元素为目标值k的个数count
     *      2. 如果不是目标值，就往前移动count位，是，则count++
     *      3. 最后返回数组的长度减去count
     * */
    public static int removeElement(int[] nums, int val) {
        if (nums.length==0)
            return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[i-count] = nums[i];
            } else {
                count++;
            }
        }

        /*for (int i=0; i< nums.length-count; i++) {
            System.out.print(nums[i] + " ");
        }*/
        System.out.println();
        return nums.length-count;
    }
}
