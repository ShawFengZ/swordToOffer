package leetcode.t43_MultiplyStrings;

import java.math.BigInteger;
import java.util.Stack;

/**
 * @author zxf
 * @date 2018/10/18 16:08
 */
public class Solution43 {
    /**
     * 题目描述：
     *      字符串乘法
     * 思路一：
     *      大数,虽然不能用，但是还是通过了。哈哈哈，皮一下
     * 思路二：
     *      字符串乘法
     * */
    public static String multiply(String num1, String num2) {
        BigInteger num1I = new BigInteger(num1);
        BigInteger num2I = new BigInteger(num2);

        BigInteger ans = num1I.multiply(num2I);
        return ans.toString();
    }

    //字符串乘法
    public static String multiply2(String num1, String num2){
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String ans = "";
        for (int i = num1.length()-1; i >= 0; i--) {
            int tempInt = num1.charAt(i)-48;
            //个位数乘以一个字符串
            String tempStr = multiply(tempInt, num2, num1.length()-i-1);
            ans = addStringNum(ans, tempStr);
        }
        return ans;
    }

    //个位数和字符串的乘法，i代表后面要填的0的个数
    private static String multiply(int num1, String num2, int numOf0){
        String ans = "";
        int remainder = 0;
        Stack<Integer> stack = new Stack<>();
        while (numOf0 != 0) {
            stack.push(0);
            numOf0--;
        }
        for (int i = num2.length()-1; i >= 0; i--) {
            int mulAns = num1 * (num2.charAt(i) - 48) + remainder;
            stack.push(mulAns % 10);
            remainder = mulAns / 10;
        }
        if (remainder != 0)
            stack.push(remainder);
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    //字符串数字的加法
    private static String addStringNum(String num1, String num2){
        if (num1.length() == 0)
            return num2;
        if (num2.length() == 0)
            return num1;
        Stack<Integer> stack = new Stack<>();
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int remainder = 0;
        while (index1 >= 0 && index2 >= 0){
            int tempNum = num1.charAt(index1) - 48 + num2.charAt(index2) - 48 + remainder;
            stack.push(tempNum % 10);
            remainder = tempNum / 10;
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            int tempInt = num1.charAt(index1) - 48 + remainder;
            stack.push(tempInt % 10);
            remainder = tempInt / 10;
            index1--;
        }
        while (index2 >= 0) {
            int tempInt = num2.charAt(index2) - 48 + remainder;
            stack.push(tempInt % 10);
            remainder = tempInt / 10;
            index2--;
        }
        if (remainder != 0)
            stack.push(remainder);
        String ans = "";
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
