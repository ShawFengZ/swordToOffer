package leetcode.t01_twoSum;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author zxf
 * @date 2018/9/25 19:26
 */
public class Solution01 {
    /**
     * 题目描述：
     *      给定一个数组和一个数，找出数组中两个数之和为这个数的下标出来
     * 思路一：
     *      1. 借助哈希表
     * 思路二：
     *      2. 先排序
     * */
    public static int[] twoSum1(int[] nums, int target){
        Hashtable<Integer, Integer> numTable = new Hashtable<>();
        int[] res = new int[2];
        //将数据放到哈希表中
        for (int i = 0; i < nums.length; i++) {
            if (numTable.containsKey(target-nums[i])){
                res[0] = numTable.get(target-nums[i]);
                res[1] = i;
            } else {
                numTable.put(nums[i], i);
            }
        }
        return res;
    }

    /**
     * 1. 先对数组进行排序
     * 2. 对数组从两端开始遍历，如果和较小则index1后移，如果和较大，index2前移
     *
     * 排序后顺序会打乱？
     *      所以，如果本身是排序版的，则可以使用这种方法
     * */
    public static int[] twoSum2(int[] nums, int target){
        Arrays.sort(nums);
        int index1 = 0;
        int index2 = nums.length-1;
        int[] res = new int[2];
        while (index2 > index1) {
            int sum = nums[index1] + nums[index2];
            if (sum < target) {
                index1++ ;
            } else if (sum > target) {
                index2 --;
            } else {
                res[0] = index1;
                res[1] = index2;
                break;
            }
        }
        return res;
    }

}
