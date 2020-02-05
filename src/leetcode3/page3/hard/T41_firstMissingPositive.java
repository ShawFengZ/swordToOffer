package leetcode3.page3.hard;

public class T41_firstMissingPositive {
    /**
     * 第一个缺失的正数
     *
     * 方法一：使用num自增检查
     * 方法二：建立一个新的数组做散列
     * */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int num = 1;
        for (int index=0; index < nums.length; index++) {
            if (nums[index] == num) {
                num++;
                index = -1;
            }
            if (index == nums.length - 1) {
                break;
            }
        }
        return num;
    }

    public int firstMissingPositive2(int[] nums){
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int[] tmp = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            if (nums[i] > 0 && nums[i] <= nums.length) {
                tmp[nums[i]] = 1;
            }
        }
        for(int i=1; i<tmp.length; i++){
            if (tmp[i] == 0) {
                return i;
            }
        }
        return tmp.length;
    }
}
