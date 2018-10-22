package leetcodeDifficult.t4_MidianOfTwoSortedArrays;

import java.util.Arrays;

/**
 * @author zxf
 * @date 2018/10/19 9:07
 */
public class SolutionD04 {
    /**
     * 题目描述：
     *      两个排序数组，求两个排序数组的中位数。时间复杂度为O(log(m+n))
     * 思路：
     *      1. 本题要求的时间复杂度肯定不能用遍历的方法，考虑二分法。
     *      2. 分别找第(m+n+1)/2个，和第(m+n+2)/2两个元素，求其平均值(无论m+n是奇数还是偶数，都是这样，如果m+n是奇数，这俩值相同)
     *      3. 下面定义一个函数从两个有序数组中找到第k个元素：
     *          a). 使用两个变量i,j来标记数组nums1和nums2的起始位置；
     *          b). 特殊情况：一个数组的起始位置大于等于这个数组的长度，说明其所有数字均被淘汰了，相当于在另一个数组中查找
     *                        如果k等于1，只要比较nums1和nums2的起始位置上的数字即可。
     *          c). 一般情况：二分法，对k二分，查找第k/2个元素。(注意这里由于两个数组的长度不定，有可能没有)
     *                        check数组中有没有第k/2个元素，如果有就取出来，如果没有就赋值一个整型最大值。
     *                        如果某个数组没有第k/2个数字，那么我们就淘汰另一个数组的前k/2个数字即可。(两个数组中一定有一个存在第k/2个元素的)
     *                        比较两个数组的第k/2个元素midVal1和midVal2的大小，如果第一个数组的第k/2更小，说明我们要找的元素肯定不再它的k/2中，因此i
     *                              向后移动k/2，k-k/2，递归调用。
     *                        反之亦然
     * */
    //解法一：
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1)/2, right =(m + n + 2)/2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right))/2.0;
    }
    /**
     * 找两个数组中的第k个元素
     * */
    private int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if (i >= nums1.length)
            return nums2[j + k - 1];
        if (j >= nums2.length)
            return nums1[i + k - 1];
        int midVal1 = (i + k/2 - 1 < nums1.length) ? nums1[i + k/2 - 1]:Integer.MAX_VALUE;
        int midVal2 = (j + k/2 - 1 < nums2.length) ? nums2[j + k/2 - 1]:Integer.MAX_VALUE;
        if (midVal1 < midVal2)
            return findKth(nums1, i + k/2, nums2, j, k - k/2);
        else
            return findKth(nums1, i, nums2, j + k/2, k-k/2);
    }

    /**
     * 思路二：
     *      上面的解法一直使用的是原数组，同时用了两个变量分别标记当前的起始位置。我们可以直接生成新的数组。
     *      1. 首先判断数组是否为空，为空的话直接在另一个数组找第k个即可。
     *      2. 如果k=1，直接比较两个数组的第一个元素即可。
     *      3. 这里我们分别取出两个数组的第k/2个数字的位置和坐标i和j，为了避免数组没有第k/2个数字的情况，我们每次都和数组的长度比较，取出最小值。
     *      4. 上面的解法取出的是值，这里取出的是位置坐标。
     * */
    private int findKth2(int[] nums1, int[] nums2, int k){
        int m = nums1.length, n = nums2.length;
        if (m == 0)
            return nums2[k - 1];
        if (n == 0)
            return nums1[k - 1];
        if (k == 1)
            return Math.min(nums1[0], nums2[0]);
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (nums1[i-1] > nums2[j-1])
            return findKth2(nums1, Arrays.copyOfRange(nums2, j, n), k-j);
        else
            return findKth2(Arrays.copyOfRange(nums1, i, m), nums2, k-i);
    }

    /**
     * 解法三：
     *      迭代形式的二分搜索法求解。还没弄明白
     * */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length;
        if (m < n) return findMedianSortedArrays2(nums2, nums1);
        if (n == 0)
            return (nums1[(m-1)/2] + nums1[m/2])/2.0;
        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;

        }
        return 1.0;
    }
}
