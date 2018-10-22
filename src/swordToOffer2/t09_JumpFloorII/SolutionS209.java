package swordToOffer2.t09_JumpFloorII;

/**
 * @author zxf
 * @date 2018/10/22 10:36
 */
public class SolutionS209 {
    /**
     * 变态跳台阶：
     *      每次可以1级，2级，...,n级
     * */
    private static int jumpFloorII(int target){
        if (target == 0)
            return 0;
        if (target == 1)
            return 1;
        return 2*jumpFloorII(target-1);
    }

    private static int jumpFloorII2(int target){
        if (target == 0)
            return 0;
        if (target == 1)
            return 1;
        int[] ans = new int[target+1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= target; i++) {
            ans[i] = ans[i-1] * 2;
        }
        return ans[target];
    }

    public static void main(String[] args) {
        System.out.println(jumpFloorII(3));
        System.out.println(jumpFloorII2(3));
    }
}
