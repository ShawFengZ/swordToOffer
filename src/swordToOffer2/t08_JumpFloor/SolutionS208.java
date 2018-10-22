package swordToOffer2.t08_JumpFloor;

/**
 * @author zxf
 * @date 2018/10/22 10:27
 */
public class SolutionS208 {
    /**
     * 跳台阶：
     *      一只青蛙依次可以跳1级台阶，也可以跳两级。求青蛙跳上一个n级台阶共有多少中跳法。
     * 思路：
     *      1. 不能简单的递归哦
     *      2. 还是用数组记录下沿途的数字
     * */
    private static int jumpFloor(int target){
        if (target == 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        return jumpFloor(target-1) + jumpFloor(target-2);
    }

    private static int jumpFloor2(int target){
        if (target == 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int[] ans = new int[target+1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;
        for (int i=3; i <= target; i++) {
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[target];
    }

    //测试
    public static void main(String[] args) {
        //System.out.println(jumpFloor(10000));
        System.out.println(jumpFloor2(10000));
    }

}
