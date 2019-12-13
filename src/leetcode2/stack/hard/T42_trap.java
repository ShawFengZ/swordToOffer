package leetcode2.stack.hard;

public class T42_trap {
    /**
     * 接雨水
     *
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，
     * 下雨之后能接多少雨水。
     *
     * 思路：
     * 1. 找到最好的那个柱子
     * */
    private static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxTrap = 0;
        int hightEstIndex = -1;
        int highest = Integer.MIN_VALUE;
        for (int i=0; i<height.length; i++) {
            if (height[i] > highest) {
                highest = height[i];
                hightEstIndex = i;
            }
        }
        int h = height[0];
        for (int i=0; i<hightEstIndex; i++) {
            if (height[i] < h) {
                maxTrap += h - height[i];
            } else {
                h = height[i];
            }
        }
        h = height[height.length-1];
        for (int i = height.length-1; i>hightEstIndex; i--) {
            if (height[i] < h) {
                maxTrap += h - height[i];
            } else {
                h = height[i];
            }
        }
        return maxTrap;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);
    }
}
