package book.t14_cutRope;

/**
 * @author zxf
 * @date 2018/9/2 16:17
 */
public class SolutionBook14 {
    /**
     *  题目描述：
     *      给一根长度为n的绳子，把绳子剪成m段(m,n都是整数，且m>1, n>1)，每段绳子的长度
     *      记为k[0], k[1], ..., k[m]
     *      k[0]*k[1]*k[2]*...*k[m]的最大值是多少
     * */

    /**
     * 动态规划
     *      1. length=2时，只能分割成1*1；
     *         length=2时，分割成1*2最大
     *      2. products[i]存放的是length=i时得到的乘积的最大值
     * */
    public static int maxProductAfterCutting(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] products = new int[length+1];
        // 数组中第i个元素表示把长度为i的绳子剪成若干段后的乘积的最大值
        products[0]=0; products[1]=1; products[2]=2; products[3]=3;
        int max = 0;

        for (int i=4; i<=length; i++){
            max = 0;
            /**
             * 思路：
             *      一段绳子的分割乘积最大—>分割成两端a,b使得a*b乘积最大，再去分别求a,b的乘积最大
             * */
            // 求出所有可能的f(j) * f(i-j)并比较他们的最大值
            for (int j=1; j<=i/2; ++j){
                int product = products[j] * products[i-j];
                if(max<product)
                    max = product;

                products[i] = max;
            }
        }

        max = products[length];
        return max;
    }


    /**
     * 贪婪算法：
     *
     * */
    public int maxProductAfterCutting_soluion2(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        //尽可能多地剪去长度为3的绳子
        int timesOf3 = length/3;

        //当绳子最后剩余的长度为4的时候，不能再减去长度为3的绳子段
        if (length - timesOf3 * 3 == 1)
            timesOf3 -= 1;

        int timesOf2 = (length - timesOf3) / 2;
        return (int)((Math.pow(3, timesOf3))*(int)(Math.pow(2, timesOf2)));

    }

}
