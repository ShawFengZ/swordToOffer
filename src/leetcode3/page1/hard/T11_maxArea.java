package leetcode3.page1.hard;

public class T11_maxArea {
    /**
     * 盛最多水的容器：
     * 方法一：暴力法
     * 1. 循环找到最多的水
     *
     * 方法二：双指针法
     * 1. i指向0，j指向最高位，计算和更新面积；
     * 2. 更新较小的那个坐标
     * */
    private static int maxArea(int[] height) {
        if(height == null || height.length <= 1) {
            return 0;
        }
        int i=0, j=height.length-1;
        int area = 0, maxArea = 0;
        while(i < j) {
            area = Math.min(height[i], height[j]) * (j-i);
            if(area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    //代码还可以优化
    private static int maxArea2(int[] height) {
        if(height == null || height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        for (int i=0, j=height.length-1; i<j; ) {
            int minHeight = height[i] < height[j]? height[i++]:height[j--];
            maxArea = Math.max(maxArea, (j-i+1)*minHeight);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = maxArea(height);
        System.out.println(area);
    }
}
