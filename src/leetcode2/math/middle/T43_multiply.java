package leetcode2.math.middle;

import java.math.BigInteger;

public class T43_multiply {
    /**
     * 字符串乘法
     *
     * 方法一：大数
     *
     * 方法二：字符串操作，优化版数乘法
     * */
    private static String multiply(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        BigInteger n3 = n1.multiply(n2);
        return n3.toString();
    }

    private static String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] res = new int[num1.length()+num2.length()];
        for (int i=num1.length()-1; i>=0; i--) {
            int n1 = num1.charAt(i)-'0';
            for (int j=num2.length()-1; j>=0; j--) {
                int n2 = num2.charAt(j)-'0';
                int sum = (res[i+j+1]+n1*n2);
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<res.length; i++) {
            if (i==0 && res[i]==0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "311231";
        String num2 = "345370137107164018312831073";
        String multiply = multiply2(num1, num2);
        String multiply1 = multiply(num1, num2);
        System.out.println(multiply);
        System.out.println(multiply1);
    }
}
