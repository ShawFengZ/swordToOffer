package t12_power;

/**
 * @author zxf
 * @date 2018/8/11 19:00
 */
public class Solution12 {
    public double Power(double base, int exponent) {
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
}
