package swordToOffer3;

public class T10_rectCover {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * 思路：
     * 0 1 2 3 5 8
     * f(n) = f(n-1)+f(n-1)
     * */
    public static int RectCover(int target) {
        if (target <= 3) {
            return target;
        }
        int a = 2, b = 3;
        int s = 0;
        for (int i=3; i<target; i++) {
            s = a + b;
            a = b;
            b = s;
        }
        return s;
    }

}
