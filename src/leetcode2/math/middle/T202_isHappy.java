package leetcode2.math.middle;

public class T202_isHappy {
    /**
     * 快乐数
     * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，
     * 那么这个数就是快乐数。
     * */
    private static boolean isHappy(int n) {
        if (n == 4) {
            return false;
        }
        int result = 0;
        while (n > 0) {
            result += Math.pow(n%10, 2);
            n = n/10;
        }
        return result == 1 || isHappy(result);
    }
}
