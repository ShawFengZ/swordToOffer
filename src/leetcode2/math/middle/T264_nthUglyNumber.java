package leetcode2.math.middle;

public class T264_nthUglyNumber {
    /**
     * 找到第n个丑数
     * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
     *
     * 方法一：暴力法，做个数组，时间复杂度较高；
     * 方法二：三指针法，遍历不用那么多次
     * */
    private static int nthUglyNumber(int n) {
        int[] res = new int[n+1];
        if (n <= 6) {
            return n;
        }
        res[1] = 1; res[2] = 2; res[3] = 3;
        for (int i=4; i<=n; i++) {
            int m2 = getMn(res, i, 2);
            int m3 = getMn(res, i, 3);
            int m5 = getMn(res, i, 5);
            res[i] = Math.min(Math.min(m2, m3), m5);
        }
        return res[n];
    }

    private static int getMn(int[] res, int n, int k){
        for (int i=1; i<=n-1; i++) {
            if (res[i] * k > res[n-1]) {
                return res[i] * k;
            }
        }
        return -1;
    }

    private static int nthUglyNumber2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int l2 = 0, l3 = 0, l5 = 0;
        for (int i=1; i<n ;i++) {
            int t2 = 2 * dp[l2];
            int t3 = 3 * dp[l3];
            int t5 = 5 * dp[l5];
            dp[i] = Math.min(Math.min(t2, t3), t5);
            if (dp[i] == t2) {
                l2++;
            }
            if (dp[i] == t3) {
                l3++;
            }
            if (dp[i] == t5) {
                l5++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int i = nthUglyNumber2(10);
        System.out.println(i);
    }
}
