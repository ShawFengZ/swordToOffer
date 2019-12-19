package leetcode2.math.easy;

public class T263_isUgly {
    /**
     * 判断一个数是否是丑数
     *
     * 思路1：
     * 如果能被5整除就整除5
     * 如果能被3整除就整除3
     * 如果能被2整除就整除2
     * 最后剩下1 说明只有这三个质因数
     * */
    private static boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 5 == 0) {
            num = num/5;
        }
        while (num%3 == 0) {
            num = num/3;
        }
        while (num % 2 == 0) {
            num = num>>1;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        boolean ugly = isUgly(7);
        System.out.println(ugly);
    }
}
