package leetcode2.stack.hard;

import java.util.Stack;

public class T84_largestRectangleArea {
    /**
     * 柱状图中最大的矩形
     *
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 方法1：暴力法（超出时间限制）
     * 直接遍历比较，时间复杂度O(n^3)
     *
     * 方法2：暴力法改进（可以通过，但是只打败了39%的提交，显然不是最优解法）
     * 1. 遍历法对每个元素进行处理；
     * 2. 在这个元素向上找，如果高度大于这个元素则往上；
     * 3. 在这个元素往下找，如果高度小于这个元素则往下；
     * 4. 计算maxArea
     *
     * 方法3：暴力法优化2(没有第二种解法好，打败20%的提交)
     * 1. 通过优化比较法使得时间复杂度降到O(n^2)
     *
     *
     * 方法4：分治法
     * 时间复杂度：最坏O(n^2), 平均O(nlgn),
     * 空间复杂度：最坏O(n)，递归的层数是n
     *
     * 方法5： 单调栈
     * */
    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i=0; i<heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length-stack.peek()-1));
        }
        return maxArea;
    }

    private static int largestRectangleArea4Util(int[] heights, int start, int end){
        if (start > end) {
            return 0;
        }
        int minIndex = start;
        for (int i=start; i<= end; i++) {
            if (heights[minIndex] > heights[i]) {
                minIndex = i;
            }
        }
        return Math.max(heights[minIndex] * (end-start+1),
                Math.max(largestRectangleArea4Util(heights, start, minIndex-1),
                        largestRectangleArea4Util(heights, minIndex+1, end)));
    }
    private static int largestRectangleArea4(int[] heights){
        if (heights == null || heights.length == 0) {
            return 0;
        }
        return largestRectangleArea4Util(heights, 0, heights.length-1);
    }
    private static int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i=0; i<heights.length; i++) {
            int minHeight = heights[i];
            for (int j=i; j<heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j-i+1));
            }
        }
        return maxArea;
    }

    private static int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i=0; i<heights.length; i++) {
            int h = heights[i], w = 1;
            int j = i+1;
            while (j < heights.length && heights[j] >= h) {
                j++;
                w++;
            }
            j = i-1;
            while (j >=0 && heights[j] >= h) {
                w++;
                j--;
            }
            if (maxArea < w * h) {
                maxArea = w * h;
            }
        }
        return maxArea;
    }
    private static int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i=0; i<heights.length; i++) {
            for (int j=i; j<heights.length; j++) {
                int minHeight = heights[i];
                for (int k=i; k<=j; k++) {
                    if (minHeight > heights[k]) {
                        minHeight = heights[k];
                    }
                }
                int curMaxArea = (j-i+1)*minHeight;
                if (curMaxArea > maxArea) {
                    maxArea = curMaxArea;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int area = largestRectangleArea3(nums);
        System.out.println(area);
    }
}
