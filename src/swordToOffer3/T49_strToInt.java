package swordToOffer3;

import com.sun.org.apache.regexp.internal.RE;

import java.math.BigInteger;

public class T49_strToInt {
    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     * 数值为0或者字符串不是一个合法的数值则返回0
     * */
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0 ||
                (str.length() == 1 && str.charAt(0) < '0' && str.charAt(0) > '9')) {
            return 0;
        }
        boolean flag = false;
        if (str.charAt(0) == '-') {
            flag = false;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            flag = true;
            str = str.substring(1);
        } else {//说明前面没有符号
            flag = true;
        }
        if (str.length() > 10) {
            return 0;
        }
        Long res = 0L;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
            res = res*10+str.charAt(i)-'0';
        }
        if (!flag) {
            res = -res;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return res.intValue();
    }
}
