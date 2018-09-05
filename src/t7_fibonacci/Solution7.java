package t7_fibonacci;

/**
 * @author zxf
 * @date 2018/8/11 17:52
 */
public class Solution7 {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
