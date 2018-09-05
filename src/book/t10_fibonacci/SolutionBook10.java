package book.t10_fibonacci;

/**
 * @author zxf
 * @date 2018/8/30 14:07
 */
public class SolutionBook10 {

    //递归的解法,效率实在太低了，计算100花了6分钟还不止，实在停不下来，计算了126970726次还在算
    //相当于2^0+2^1+2^2+…+2^100，这太可怕了
    public static long fibonacci1(int n){
        if (n <=0 )
            return 0;
        if (n == 1)
            return 1;
        return fibonacci1(n-1)+fibonacci1(n-2);
    }

    //改进的方法,时间复杂度是O(n)
    public static long fibonacci2(int n){
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        long fibMinusOne = 1;
        long fibMinusTwo = 0;
        long fibN = 0;
        for (int i=2; i<=n; ++i){//相当于是用循环代替了递归
            fibN = fibMinusOne + fibMinusTwo;

            fibMinusTwo = fibMinusOne;
            fibMinusOne = fibN;
        }
        return fibN;
    }
}
