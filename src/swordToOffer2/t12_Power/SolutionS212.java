package swordToOffer2.t12_Power;

/**
 * @author zxf
 * @date 2018/10/22 13:35
 */
public class SolutionS212 {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 思路一：时间复杂度O(n)
     *      1. 全面的做法：考虑各种输入的情况
     * 思路二：时间复杂度O(log2n)
     *      1. 公式a^n = a^n/2 * a^n/2
     * */
    private double Power(double base, int exponent) {
        double ans = 1;
        if (exponent == 0){
            return 1;
        }else if (exponent > 0){
            for (int i=1; i<=exponent; i++){
                ans *= base;
            }
            return ans;
        }else{
            for (int i=1; i<= - exponent; i++){
                ans *= base;
            }
            ans = 1.0/ans;
            return ans;
        }
    }

    //测试用例没有过，这是对于无符号数的做法
    private static double Power2(double base, int exponent){
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double ans = Power2(base, exponent/2);
        ans *= ans;
        if (exponent%2==1)//判断是否是奇数
            ans *= base;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Power2(2, -3));
    }
}
