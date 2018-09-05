package t9_jumpFloor2;

/**
 * @author zxf
 * @date 2018/8/11 18:02
 */
public class Solution9 {

    /**
     * 分析：
     *      f(n)=f(0)+f(1)+...+f(n-1)
     *      又有f(n-1) = f(0)+f(1)+...+f(n-2)
     *      因此f(n)=2f(n-1)
     * */
    public int JumpFloorII(int target) {
        if (target == 0)
            return 0;
        if (target == 1)
            return 1;
        return 2*JumpFloorII(target-1);
    }
}
