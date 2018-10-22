package leetcode.t41_FirstMissingPositive;

import java.util.Arrays;

/**
 * @author zxf
 * @date 2018/10/18 14:34
 */
public class Solution41 {

    /**
     * 题目描述：
     *      找第一个缺失的正数
     * 思路：
     *      1. 先排序
     *      2. 遍历找正数
     * */
    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 1)
            return 1;
        //先排序
        Arrays.sort(nums);
        int index = 0;
        int i = 0;
        for (; i < nums.length-1; i++){
            if (nums[i] == nums[i+1])
                continue;
            if (nums[i] > 0){
                index++;
                if (nums[i] != index){
                    break;
                }
            }
        }
        if (i == nums.length-1) {
            if (nums[i] == index + 1)
                index = index + 2;
            else
                index = index + 1;
        }
        return index;
    }
}
