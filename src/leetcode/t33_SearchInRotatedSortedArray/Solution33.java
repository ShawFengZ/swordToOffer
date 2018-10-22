package leetcode.t33_SearchInRotatedSortedArray;

/**
 * @author zxf
 * @date 2018/10/17 14:38
 */
public class Solution33 {
    /**
     * 题目描述：
     *      在一个旋转的升序数组中寻找一个目标值，没找到返回-1
     * 思路：
     *      1. 二分查找
     *      2. 如果左边的点比右边的点小，说明这两个点之间是有序的；
     *      3. 如果左边的点比右边的点大，说明有一半还是有序的，还是可以用二分查找
     *      4. 先判断是左边有序还是右边有序，如果是左边有序，则直接将目标与左边的最小值比较
     *                                       如果是右边有序，则直接将目标与右边的最大值比较
     * */
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] >= nums[low]){ //左边有序
                if (target >= nums[low] && target < nums[mid]) { //目标值在左边
                    high = mid - 1;
                } else{ //目标值在右边
                    low = mid + 1;
                }
            } else { //右边有序
                if (target <= nums[high] && target > nums[mid]) { //目标值在右边
                    low = mid + 1;
                } else  { //目标值在左边
                    high = mid - 1;
                }
            }
        }
        return index;
    }
}
