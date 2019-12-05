package swordToOffer3;

public class T7_fibonacci {

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）
     * 0 1 1 2 3 5 8
     * */
    public static int Fibonacci(int n) {
        if (n <= 1)
            return n;
        int a=0, b=1;
        int s=0;
        for (int i=1; i<n; i++) {
            s = a+b;
            a = b;
            b = s;
        }
        return s;
    }

}
