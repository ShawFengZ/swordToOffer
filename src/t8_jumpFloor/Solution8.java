package t8_jumpFloor;

/**
 * @author zxf
 * @date 2018/8/11 17:58
 */
public class Solution8 {
    public int JumpFloor(int target) {
        if (target==0)
            return 0;
        if (target==1)
            return 1;
        if (target==2)
            return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
