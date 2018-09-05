package t10_RectCover;

/**
 * @author zxf
 * @date 2018/8/11 18:20
 */
public class Solution10 {
    /**
     * 分析：
     *      1. 大矩形的形状和面积是2xn
     *      2. 小矩形时1x2
     *      3. 相当于一次走一步、或者一次走两步，共有多少种走法
     * */
    public int RectCover(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1 || target == 2){
            return target;
        }
        return RectCover(target-1)+ RectCover(target-2);
    }
}
