package leetcode.t07_reverseInteger;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/**
 * @author zxf
 * @date 2018/10/8 15:33
 */
public class Solution07 {
    /**
     * 输入32位无符号数，翻转这个数字
     * */
    public static int reverse(int x){
        if (x == 0 ||x < MIN_VALUE || x > MAX_VALUE)
            return 0;
        //判断是否是负数
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = -x;
        }
        //建立一个队列
        Queue<Integer> queue = new ArrayDeque<>();
        while (x != 0) {
            int temp = x % 10;
            queue.offer(temp);
            x /= 10;
        }
        int ans = 0;
        while (!queue.isEmpty()) {//最重要的就是这里的边界条件需要考虑
            if (ans > MAX_VALUE /10 || ans < MIN_VALUE/10){
                ans = 0;
                break;
            }
            ans = ans * 10 + queue.poll();
        }
        if (isNeg) {
            return  -ans;
        }else {
            return ans;
        }
    }
}
