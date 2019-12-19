package leetcode2.math.easy;

public class T326_isPowerOfThree {
    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     *
     * 进阶：不用循环和递归
     *      n能被1162261467整除则可以
     * */
    private static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n >= 3) {
            if (n % 3 != 0) {
                return false;
            }
            n =n / 3;
        }
        return n==1;
    }

    private static boolean isPowerOfThree2(int n){
        return n > 0 && 1162261467%n == 0;
    }

    public static void main(String[] args) {
        int n = 81;
        boolean powerOfThree = isPowerOfThree(n);
        System.out.println(powerOfThree);
    }
}
