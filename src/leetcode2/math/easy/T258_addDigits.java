package leetcode2.math.easy;

public class T258_addDigits {
    /**
     * 各位相加
     *
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * 进阶：
     * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
     * */
    private static int addDigits(int num) {
        if (num < 0) {
            return -1;
        }
        int result = 0;
        while (num > 0) {
            result += num%10;
            num = num/10;
        }
        return result<10?result:addDigits(result);
    }

    /**
     * X = 100*a + 10*b + c = 99*a + 9*b + (a+b+c)；所以对9取余即可。
     *
     * 除了传统的单纯循环，还可以找规律。假如一个三位数'abc'，
     * 其值大小为s1 = 100 * a + 10 * b + 1 * c，经过一次各位相加后，
     * 变为s2 = a + b + c，减小的差值为(s1 -s2) = 99 * a + 9 * b，
     * 差值可以被9整除，每一个循环都这样，缩小了9的倍数。当num小于9，
     * 即只有一位时，直接返回num，大于9时，如果能被9整除，
     * 则返回9（因为不可能返回0也不可能返回两位数及以上的值），
     * 如果不能被整除，就返回被9除的余数。
     * */
    private static int addDigits2(int num){
        return (num-1)%9+1;
    }

    public static void main(String[] args) {
        int i = addDigits(38);
        System.out.println(i);
    }
}
