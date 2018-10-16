package leetcode.t09_palindromeNumber;

import com.sun.org.apache.regexp.internal.RE;

import java.net.Inet4Address;
import java.util.Stack;

/**
 * @author zxf
 * @date 2018/10/8 16:08
 */
public class Solution09 {
    /**
     * 判断是否是回文数
     * 思路：
     *      1. 将数字转为字符串
     *      2. 逆转字符串
     *      3. 判断两个字符串是否相同
     * 思路2：
     *      不能将数字换为字符串
     *      1. 逆转数字
     *         1. 如果是负数，一定是false
     *         2. 如果是整数，就将其逆转
     *      2. 判断数字是否相等
     * */
    public static boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        String num1 = Integer.toString(x);
        //逆转字符串
        String num2 = reverseString(num1);
        return num1.equals(num2);
    }
    /**
     * 思路：
     *      1. 将字符依次放入栈中
     *      2. 取出栈中字符依次加到一个新的string后
     * */
    private static String reverseString(String str){
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<str.length(); i++) {
            Character ch = str.charAt(i);
            stack.push(ch);
        }
        String reverseStr = "";
        while (!stack.isEmpty()) {
            reverseStr += stack.pop();
        }
        return reverseStr;
    }

    //解法2
    public static boolean isPalindrome2(int x){
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        Integer reverseNum = reverseNum(x);
        return reverseNum.equals(x);
    }

    public static Integer reverseNum(Integer num){
        Integer newNum = 0;
        while (num != 0) {
            if (newNum > Integer.MAX_VALUE || newNum < Integer.MIN_VALUE){
                newNum = null;
                break;
            }
            newNum = newNum * 10 + num % 10;
            num = num / 10;
        }
        return newNum;
    }
}
