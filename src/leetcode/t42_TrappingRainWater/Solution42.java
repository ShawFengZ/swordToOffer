package leetcode.t42_TrappingRainWater;

/**
 * @author zxf
 * @date 2018/10/18 15:01
 */
public class Solution42 {
    /**
     * 题目描述：
     *      给一组非负的数组，计算如果下雨能装多少水。
     * 思路：
     *      1. 遍历找到最高点；
     *      2. 从两边往中间遍历，实时记录第二高点，水位就是这个第二高减去当前水量
     * */
    public static int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int sumTrap = 0;
        int highestIndex = 0;
        for (int i=0; i < height.length; i++) {
            if (height[i] > height[highestIndex])
                highestIndex = i;
        }
        int secondHIndex = 0;
        for (int i=0; i < highestIndex; i++) {
            if (height[i] > height[secondHIndex])
                secondHIndex = i;
            else {
                sumTrap += height[secondHIndex] - height[i];
            }
        }
        secondHIndex = height.length-1;
        for (int i = height.length-1; i > highestIndex; i--) {
            if (height[i] > height[secondHIndex])
                secondHIndex = i;
            else {
                sumTrap += height[secondHIndex] - height[i];
            }
        }
        //遍历找到最高点
        return sumTrap;
    }
}
