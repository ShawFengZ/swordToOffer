package leetcode.t34FindInSortedArray;

/**
 * @author zxf
 * @date 2018/10/18 9:17
 */
public class Solution34 {
    /**
     * 找到一个元素在一个排序数组中的最开始和最后出现的位置，要求时间复杂度为O(logn)
     *
     * 思路：
     *      二分法
     *      1. nums[mid] < target, target在右边
     *      2. nums[mid] > target, target在左边
     *      3. nums[mid] = target, 向前+向后查找直到找到最大的和最小的target
     * */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums.length == 0)
            return res;
        int low = 0, high = nums.length-1;
        return binarySearch(nums, low, high, target);
    }

    //二分查找
    private static int[] binarySearch(int[] nums, int low, int high, int target){
        int[] res = new int[]{-1, -1};
        int i = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                int indexH = mid, indexL = mid;
                while (indexH+1<nums.length && nums[indexH+1] == target)
                    indexH++;
                while (indexL-1>=0 && nums[indexL-1] == target)
                    indexL--;
                res[0] = indexL;
                res[1] = indexH;
                break;
            }
        }
        return res;
    }
}
