package swordToOffer3;

public class T37_getNumberOfK {
    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * 思路一：
     * 1. 直接顺序查找，O(n)
     *
     * 思路二：
     * 1. 二分查找
     * 2. 顺序查找
     *
     * 思路三：
     * 1. 二分查找
     * */
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == k) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int GetNumberOfK2(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int cnt = 0;
        int low = 0, high = array.length-1;
        int mid = 0;
        while (low < high) {
            mid = low + high >> 1;
            if (array[mid] == k) {
                break;
            } else if (array[mid] < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        if (array[mid] != k)
            return 0;
        int mid2 = mid+1;
        while (mid >= 0 && array[mid] == k) {
            cnt++;
            mid--;
        }
        while (mid2 < array.length && array[mid2] == k) {
            cnt++;
            mid2++;
        }
        return cnt;
    }
}
