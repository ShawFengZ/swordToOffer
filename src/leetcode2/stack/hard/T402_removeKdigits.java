package leetcode2.stack.hard;

import java.util.Stack;

public class T402_removeKdigits {
    /**
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     *
     * 解法一：直接处理字符串（O(n^2)，打败85%的提交）
     * 1. 从左往后找到第一个比后面大的字符，删除，清0，k次扫描
     *
     * 解法二：单调栈
     *
     * */
    private static String removeKdigits2(String num, int k){
        if (k >= num.length() || num.length()== 0) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(num.charAt(0)-'0');
        for (int i=1; i<num.length(); i++) {
            int now = num.charAt(i)-'0';
            while (!stack.isEmpty() && k>0 && now < stack.peek()) {
                stack.pop();
                k--;
            }
            if (now != 0 || !stack.isEmpty()) {
                stack.push(now);
            }
        }
        while (k > 0) {
            k--;
            stack.pop();
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private static String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i=0; i<k; i++) {
            int idx = 0;
            for (int j=1; j<sb.length() && sb.charAt(j)>=sb.charAt(j-1); j++) {
                idx = j;
            }
            sb.deleteCharAt(idx);
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String nums = "10200";
        String kdigits = removeKdigits(nums, 1);
        System.out.println(kdigits);
    }
}
