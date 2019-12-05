package swordToOffer3;

public class T8_jumpFloor {
    /**
     * 跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * 思路
     * f(n) = f(n-1) + f(n-1)
     * 0 1 2 3 5
     * */
    public int JumpFloor(int target) {
        if (target <= 3)
            return target;
        int a=2, b=3;
        int s=0;
        for (int i=3; i<target; i++) {
            s = a+b;
            a = b;
            b = s;
        }
        return s;
    }
}
