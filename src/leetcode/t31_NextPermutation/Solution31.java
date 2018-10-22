package leetcode.t31_NextPermutation;

/**
 * @author zxf
 * @date 2018/10/17 9:37
 */
public class Solution31 {

    /**
     * 题目描述：
     *      找全排列的下一个排列
     * 思路：
     *      1. 从后往前遍历
     *      2. 遇到降序后，将降序的下一个元素nums[index]和后面的第一个小于它的元素交换
     *      3. 再将这个元素nums[index]后面的元素进行专职
     * */
    public static void nextPermutation(int[] nums) {
        boolean flag = false;
        int index = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                nums = swap(nums, i);
                index = i+1;
                break;
            }
        }
        //将i后面的数字全部逆转
        nums = reverseArray(nums, index, nums.length-1);
        //输出nums测试
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    //从后往前数，第一个大于nums[index]的值，交换
    private static int[] swap(int[] nums, int index){
        int indexS = index;
        for (int i = nums.length-1; i > index; i--) {
            if (nums[index]  < nums[i]) {
                indexS = i;
                break;
            }
        }
        //交换index和indexS
        int tempNum = nums[index];
        nums[index] = nums[indexS];
        nums[indexS] = tempNum;
        //返回数组
        return nums;
    }

    /**
     * 转置数组
     * */
    public static int[] reverseArray(int[] nums, int start, int end) {
        if (start == end)//说明只有一个数字，不用逆转
            return nums;
        //需要反转的数字有偶数个
        for (int i = start; i <= (end+start)/2; i++) {
            int temp = nums[i];
            nums[i] = nums[end-i+start];
            nums[end-i+start] = temp;
        }
        return nums;
    }
}
