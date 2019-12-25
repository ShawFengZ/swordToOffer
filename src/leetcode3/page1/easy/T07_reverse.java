package leetcode3.page1.easy;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.OMGVMCID;

public class T07_reverse {
    /**
     * 整数反转
     * */
    private static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res*10 + x%10;
            x /= 10;
        }
        return res<Integer.MIN_VALUE||res>Integer.MAX_VALUE?0:(int) res;
    }

    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(reverse);
    }
}
