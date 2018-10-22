package swordToOffer2.t07_Fibonacci;

import java.io.File;

/**
 * @author zxf
 * @date 2018/10/22 10:18
 */
public class SolutionS207 {
    /**
     * 斐波那契数列：
     * 思路：
     *      1. 不要简单的用递归解决
     *      2. 用循环的方式，将路上的值全部记录
     * */
    private static int Fibonacci(int n){
        if(n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    private static int Fibonacci2(int n){
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(30));
        System.out.println(Fibonacci2(30));
    }
}
