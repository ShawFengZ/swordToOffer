package leetcode.t35_SearchInsertPosition;

/**
 * @author zxf
 * @date 2018/10/18 9:46
 */
public class Solution35 {
    /**
     * 题目描述：
     *      一个排序数组nums[]和一个value，在nums[]找value，如果找到则返回那个index，如果没找到则返回应该插入的位置
     * 思路：二分查找变形
     *      1. nums[mid] < target, 在右边，low = mid+1
     *      2. nums[mid] > target, 在左边，high = mid-1;
     *      3. nums[mid] = target, 返回index;
     *      4. 查找到最后，如果nums[mid] < target, 返回mid+1, 否则返回mid
     * */
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int low = 0, high = nums.length-1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        if (nums[mid] < target)
            return mid+1;
        else
            return mid;
    }
}
