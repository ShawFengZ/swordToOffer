package leetcode2.math.middle;

public class T313_nthSuperUglyNumber {
    /**
     * 超级丑数
     *
     * n指针法
     * */
    private static int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || primes.length == 0) {
            return -1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int[] ln = new int[primes.length];
        for (int i=1; i<n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j=0; j<primes.length; j++) {
                if (primes[j] * dp[ln[j]] < min) {
                    min = primes[j] * dp[ln[j]];
                }
            }
            dp[i] = min;
            for (int j=0; j<primes.length; j++) {
                if (primes[j] * dp[ln[j]] == min){
                    ln[j]++;
                }
            }
        }
        /*for (int i=0; i<dp.length; i++) {
            System.out.print(dp[i] + " ");
        }*/
        return dp[n-1];
    }

    public static void main(String[] args) {
        int n = 15;
        int[] primes = {3,5,7,11,19,23,29,41,43,47};
        int number = nthSuperUglyNumber(n, primes);
        System.out.println(number);
    }
}
