package swordToOffer2.t11_NumOf1;

/**
 * @author zxf
 * @date 2018/10/22 10:59
 */
public class SolutionS211 {
    /**
     * 题目描述：
     *      输入一个整数，输出二进制中1的个数。其中负数用补码表示。
     * 思路一：
     *      1. 转为二进制
     *      2. 计算1的个数
     * 思路二：
     *      1. 实际中应该用位移运算代替乘除法。
     * */
    private int numberOf1(int n){
        int count = 0;
        while (n!=0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
