package leetcode.t11_containsMostWater;

/**
 * @author zxf
 * @date 2018/10/8 16:37
 */
public class Solution11 {
    /**
     * 给定有n个非负数字的数组，求他们随机两个数的积的最大值
     * 思路：
     *      1.从两边向中间移动
     *      2. 如果height[i] < height[j]，则i++; 否则j++
     * */
    public static int maxArea(int[] height){
        if (height.length < 2 || height == null)
            return -1;
        int res = 0, i = 0, j = height.length-1;
        while (i < j) {
            res = Math.max(res, Math.min(height[i], height[j]) * (j-i));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return res;
    }
}
