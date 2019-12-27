package leetcode3.page1.middle;

import java.util.HashMap;
import java.util.Map;

public class T13_romanToInt {
    /**
     * 罗马数转数字
     * */
    private static int romanToInt(String s) {
        int sum = 0;
        if (s == null || s.length() == 0) {
            return sum;
        }
        char[] chars = s.toCharArray();
        int preNum = getValue(chars[0]);
        for (int i=1; i<chars.length; i++) {
            int num = getValue(chars[i]);
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch){
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        int iii = romanToInt("VI");
        System.out.println(iii);
    }
}
