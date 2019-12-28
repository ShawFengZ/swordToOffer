package leetcode3.page2.easy;

public class T27_removeElement {
    /**
     * 移除元素
     *
     * 改成while循环后速度更快了
     * */
    private static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int i = 0;
        while (i<nums.length) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
            i++;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int len = removeElement(nums, 2);
        System.out.println(len);
        for (int i=0; i<len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
