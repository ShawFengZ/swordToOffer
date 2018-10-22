package swordToOffer2.t10_RectCover;

import org.w3c.dom.css.Rect;

/**
 * @author zxf
 * @date 2018/10/22 10:48
 */
public class SolutionS210 {
    /**
     * 矩阵覆盖：
     *      我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 思路：
     *      不能用简单的递归来处理；
     * */
    private static int RectCover(int target) {
        if (target == 0)
            return 0;
        if (target == 1 || target == 2)
            return target;
        return RectCover(target-1) + RectCover(target-2);
    }

    private static int RectCover2(int target){
        if (target < 3)
            return target;
        int[] ans = new int[target + 1];
        ans[0] = 0; ans[1] = 1; ans[2] = 2;
        for (int i = 3; i <= target; i++) {
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[target];
    }

    public static void main(String[] args) {
        //测试
        //System.out.println(RectCover(100));
        System.out.println(RectCover2(100));
    }
}
