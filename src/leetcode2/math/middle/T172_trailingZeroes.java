package leetcode2.math.middle;

public class T172_trailingZeroes {
    /**
     * 阶乘尾数中的0
     *
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * 思路：统计5的个数
     * */
    private static int trailingZeroes(int n) {
        int cnt = 0;
        while (n >= 5) {
            cnt += n/5;
            n /= 5;
        }
        return cnt;
    }

    public static void main(String[] args) {
        long jieChen = getJieChen(18);
        System.out.println(jieChen);

        int i = trailingZeroes(18);
        System.out.println(i);
    }

    private static long getJieChen(int n){
        long res = 1;
        for (int i=1; i<=n; i++) {
            res *= i;
        }
        return res;
    }
}
