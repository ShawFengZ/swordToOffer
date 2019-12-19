package leetcode2.math.middle;

public class T29_divide {
    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     *
     * 思路：
     * 方法一：直接使用加法，时间复杂度不满足要求的；
     * 方法二：递归
     * */
    private static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return -1;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean flag = true;
        if ((dividend < 0 && divisor > 0)
                || (dividend > 0 && divisor < 0)) {
            flag = false;
        }
        int res = 0;
        int tmp = 0;
        while (dividend > tmp) {
            tmp += divisor;
            res++;
        }
        return flag?res-1:1-res;
    }

    private static int divide2(int dividend, int divisor){
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            }
            return Integer.MAX_VALUE;
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a>0&&b<0) || (a<0&&b>0)) {
            sign = -1;
        }
        a = a>0?a:-a;
        b = b>0?b:-b;
        long res = div(a, b);
        if (sign > 0) {
            return res>Integer.MAX_VALUE?Integer.MAX_VALUE:(int) res;
        }
        return (int)-res;
    }

    private static long div(long a, long b){
        if (a < b) {
            return 0;
        }
        long cnt = 1;
        long tb = b;
        while ((tb+tb) <= a) {
            cnt *= 2;
            tb *= 2;
        }
        return cnt+div(a-tb, b);
    }

    public static void main(String[] args) {
        int divide = divide2(10, 3);
        System.out.println(divide);
    }
}
