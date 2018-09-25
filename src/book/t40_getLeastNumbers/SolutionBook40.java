package book.t40_getLeastNumbers;

/**
 * @author zxf
 * @date 2018/9/20 10:18
 */
public class SolutionBook40 {
    /**
     * 题目描述：
     *      输入n个整数，找出其中最小的k个数。
     * 思路：
     *      1. 找出最大的数和最小的数
     *      2. 定义个数组存放该范围内数字出现的次数
     *      3. 遍历这个数组，输出最小的n个数
     * 缺陷：
     *      数字必须是在一个有限足够小的范围
     * */
    public void getLeastNumbers(int[] nums, int k){
        if (nums==null || nums.length<k || k<=0)
            return;

    }
}
