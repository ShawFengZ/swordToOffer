package leetcode2.math.middle;

public class T223_computeArea {
    /**
     * 矩形面积
     *
     * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
     *
     * 思路：
     * 1. 计算矩形A的面积和B的面积
     * 2. 计算重叠部分面积，相减得结果
     * */
    private static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //计算矩形A的面积
        int maxA = (C-A)*(D-B);
        int maxB = (G-E)*(H-F);
        if (E >= C || G <= A || H <= B || F >= D) {
            return maxA + maxB;
        }
        int leftX = Math.max(A, E);
        int leftY = Math.max(B, F);
        int rightX = Math.min(C, G);
        int rightY = Math.min(D, H);
        int commonArea = (rightX-leftX)*(rightY-leftY);
        return maxA+maxB-commonArea;
    }
}
