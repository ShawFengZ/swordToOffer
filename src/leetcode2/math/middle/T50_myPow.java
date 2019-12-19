package leetcode2.math.middle;

public class T50_myPow {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * */
    private static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1/x;
        }
        if (n == 0) {
            return 1;
        }
        boolean flag = true;
        if (n < 0) {
            flag = false;
            n = -n;
        }
        double res = 0.0;
        if (n % 2 == 0) {
            res = myPow(x, n/2) * myPow(x, n/2);
        } else {
            res = x * myPow(x, n/2) * myPow(x, n/2);
        }
        return flag?res:1/res;
    }

    /**
     * 精简写法
     * */
    private static double myPow2(double x, int n) {
        double res = 1.0;
        for (int i=n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= 2;
            }
            x *= x;
        }
        return n <0?1/res:res;
    }

    public static void main(String[] args) {
        double v = myPow(2, -2);
        System.out.println(v);
    }
}
