package book.t40_getLeastNumbers;

import java.util.ArrayList;

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
     *
     * 思路2：
     *      1. 利用快速排序划分的思想，每一次划分就会有一个数字位于以数组从小到达排序的最终位置上。
     *      2. index左边的数字都小于index对应的值，index右边的都是更大的值
     *      3. 当index < k-1时，对右边进行划分
     *      4. 当index > k-1时，对左边进行划分
     * */
    public static void getLeastNumbers(int[] nums, int k){
        if (nums==null || nums.length<k || k<=0)
            return;
        ArrayList<Integer> list = new ArrayList<>(k);
        int low = 0;
        int high = nums.length -1;
        int index = partition(nums, low, high);
        while (index != k-1) {
            if (index > k-1) {
                high = index - 1;
            } else {
                low = index + 1;
            }
            index = partition(nums, low, high);
        }
        //输出前k个数字
        for (int i = 0; i<k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    //划分操作,将较小的划分到pivot左边，较大的划分到右边，返回中间基准值
    public static int partition(int[] array, int start, int end){
        int pivot = array[start];
        while (start< end) {
            while (start < end && array[end] >= pivot)
                end--;
            array[start] = array[end];
            while (start < end && array[start] <= pivot)
                start++;
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }
}
