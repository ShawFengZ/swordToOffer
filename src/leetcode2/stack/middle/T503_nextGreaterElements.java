package leetcode2.stack.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T503_nextGreaterElements {
    /**
     * 下一个更大的元素II
     *
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素
     * 的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的
     * 第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     *
     * 思路：
     * 与上题思路一样，但是将数组遍历两遍
     * */
    private static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;
        for (int i=0; i<n * 2; i++) {
            int num = nums[i%n];
            while (!stack.isEmpty() && num>nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i < n) {
                stack.add(i);
            }
        }
        return res;
    }

    private static int[] next(int[] nums){
        int n = nums.length;
        int [] res = new int[n];
        Arrays.fill(res, -1);
        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i < n*2; i++){
            int num = nums[i % n];
            while(!stack.isEmpty() && num > nums[stack.peek()]){
                res[stack.pop()] = num;
            }
            if(i < n) stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] ints = nextGreaterElements(nums);
        for (int i: ints) {
            System.out.print(i + " ");
        }
    }

}
