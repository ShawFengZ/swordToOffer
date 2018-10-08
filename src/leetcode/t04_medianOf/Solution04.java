package leetcode.t04_medianOf;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/9/26 20:05
 */
public class Solution04 {
    /**
     * 题目描述：
     *      给定两个排序的数组，长度不一定相等。取出中位数。
     * 如：nums1 = [1, 3]
     *     nums2 = [2]
     *     中位数就是2.0.
     *     如果个数是奇数，就返回两者之平均值
     *
     * 思路：
     *      1. 先判断两者长度是否是偶数
     *      2. 如果是偶数，取出index=(len1+len2)/2
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null || nums1.length<1 || nums2.length < 1)
            return -1.0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sumLen = len1 + len2;
        if (sumLen%2==0) {
            //说明是偶数
            return findMedianSortedArraysForOu(nums1, nums2, len1, len2);
        } else {
            //说明是奇数
            return findMedianSortedArraysForJi(nums1, nums2, len1, len2);
        }
    }

    //len1+len2是偶数
    private static double findMedianSortedArraysForOu(int[] nums1, int[] nums2, int len1, int len2){
        Stack<Integer> stack = new Stack<>();
        int i=0, j=0;
        int num1=0, num2=0;
        boolean flag = false;//判断在循环中是否已经找到
        while (i<=len1 && j <=len2){
            if (stack.size()==(len1+len2)/2+1) {
                num1 = stack.pop();
                num2 = stack.pop();
                flag = true;
                break;
            }
            if (nums1[i] < nums2[j]) {
                stack.push(nums1[i]);
                i++;
            } else {
                stack.push(nums2[j]);
                j++;
            }
        }
        if (!flag) {
            while (i < len1) {
                if (stack.size()==(len1+len2)/2+1) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    flag = true;
                    break;
                }
                stack.push(nums1[i++]);
            }
            while (j < len2) {
                if (stack.size()==(len1+len2)/2+1) {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    flag = true;
                    break;
                }
                stack.push(nums2[j++]);
            }
        }
        double ans = (num1+num2)/2 + 0.5;
        return ans;
    }

    //len1+len2是奇数
    private static double findMedianSortedArraysForJi(int[] nums1, int[] nums2, int len1, int len2){
        Stack<Integer> stack = new Stack<>();
        int i=0, j=0;
        double num = 0.0;
        boolean flag = false;//判断在循环中是否已经找到
        while (i<=len1 && j <=len2){
            if (stack.size()==(len1+len2)/2+1) {
                num = stack.pop();
                flag = true;
                break;
            }
            if (nums1[i] < nums2[j]) {
                stack.push(nums1[i]);
                i++;
            } else {
                stack.push(nums2[j]);
                j++;
            }
        }
        if (!flag) {
            while (i < len1) {
                if (stack.size()==(len1+len2)/2+1) {
                    num = (double)stack.pop();
                    flag = true;
                    break;
                }
                stack.push(nums1[i++]);
            }
            while (i < len2) {
                if (stack.size()==(len1+len2)/2+1) {
                    num = (double)stack.pop();
                    flag = true;
                    break;
                }
                stack.push(nums2[j++]);
            }
        }
        return num;
    }
}
