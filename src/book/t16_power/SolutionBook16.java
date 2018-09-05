package book.t16_power;

/**
 * @author zxf
 * @date 2018/9/4 15:26
 */
public class SolutionBook16 {

    /**
     * 题目描述：
     *      实现double(double base, int exponent), 求base的exponent次方。
     *      不得使用库函数，同时不考虑大数问题
     * 思路：
     *      1. 不用考虑大数问题；
     *      2. base=0的情况；
     *      3. exponent为0的情况；
     *      4. exponent为负数的情况；
     *
     *      漏了一种情况，底数为0，指数为负数的情况
     * */
    public double Power(double base, int exponent){
        if (exponent == 0){//考虑O^0=1
            return 1.0;
        }
        if (exponent > 0){
            double ans = 1.0;
            while (exponent > 0){
                ans *= base;
                exponent--;
            }
            return ans;
        } else{
            if (base == 0.0){//如果底数为0，指数为负数，没法计算
                return -1;
            }
            double ans = 1.0;
            int oppoExponent = - exponent;
            while (oppoExponent > 0){
                ans *= base;
                oppoExponent-- ;
            }
            return 1/ans;
        }
    }
}
