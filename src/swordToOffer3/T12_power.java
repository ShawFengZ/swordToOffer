package swordToOffer3;

public class T12_power {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     *
     * 思路：
     * 如果底数为0，则返回0
     * 幂数为0返回1
     * */
    public static double Power(double base, int exponent) {
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        boolean flag = false;
        if (exponent < 0){
            exponent = -exponent;
            flag = true;
        }
        double res = 0.0;
        if (exponent%2 ==0) {
            res = Power(base, exponent/2) * Power(base, exponent/2);
        } else {
            res = base * Power(base, exponent/2) * Power(base, exponent/2);
        }
        if (flag) {
            return 1/res;
        } else {
            return res;
        }
    }
}
