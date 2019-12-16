package leetcode2.stack.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T496_nextGreaterElement {
    /**
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第
     * 一个比 x 大的元素。如果不存在，对应位置输出-1。
     *
     * 思路：
     * 1. 将nums2放到map中，依次寻找
     *
     * 方法二：单调栈
     * 1. 将nums2的每个元素的下一个最大的数求出来，一起放到hashMap中
     * 2. 遍历hashMap得到结果
     * */
    private static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        int[] res = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i=0; i<nums1.length; i++) {
            boolean find = false;
            for (int j=map.get(nums1[i])+1; j<nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    find = true;
                    break;
                }
            }
            if (!find) {
                res[i] = -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        int[] ints = nextGreaterElement(nums1, nums2);
        for (int i: ints) {
            System.out.print(i + " ");
        }
    }
}
