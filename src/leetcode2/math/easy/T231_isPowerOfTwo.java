package leetcode2.math.easy;

public class T231_isPowerOfTwo {
    /**
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     * */
    private static boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if (n %2 == 1) {
                return false;
            }
            n = n/2;
        }
        return n==1;
    }

    //位运算，占空间更小
    private static boolean isPowerOfTwo2(int n){
        if (n <= 0) {
            return false;
        }
        if ((n&n-1)==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo2(218);
        System.out.println(powerOfTwo);
    }
}
