package leetcode.t29_DivideTwoInteger;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author zxf
 * @date 2018/10/16 20:02
 */
public class Solution29 {
    /**
     * 题目描述：
     *      不能用乘法和除法实现除法。
     * 思路：
     *      1. 先判断符号
     *      2. 再用加法实现
     *      时间复杂度太高了。。。
     * */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 1;
        if (dividend == Integer.MIN_VALUE){
            dividend = dividend + 1;
        }
        //用来保留最后的符号位
        boolean flag = false;
        if (dividend < 0 && divisor > 0){
            dividend = -dividend;
            flag = true;
        }
        if (dividend > 0 && divisor < 0){
            divisor = -divisor;
            flag = true;
        }
        if (dividend < 0 && divisor < 0){
            dividend = -dividend;
            divisor = -divisor;
        }
        int ans = 0;
        int sum = 0;
        while (sum <= dividend) {
            ans++;
            sum += divisor;
        }
        ans--;
        if (flag)
            ans = -ans;
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return ans;
    }
}
