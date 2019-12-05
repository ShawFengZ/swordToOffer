package swordToOffer3;

public class T9_JumpFloorII {

    /**
     * 题目:
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * 思路：
     * f(n) = f(n-1)+f(n-1)+...+f(0)
     * */
    public static int JumpFloorII(int target) {
        if (target <= 2)
            return target;
        int s = 2;
        for (int i=3; i<=target; i++) {
            s = s*2;
        }
        return s;
    }
}
