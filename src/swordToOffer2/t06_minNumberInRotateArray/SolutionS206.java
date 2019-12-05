package swordToOffer2.t06_minNumberInRotateArray;

/**
 * @author zxf
 * @date 2018/10/22 9:23
 */
public class SolutionS206 {
    /**
     * 题目描述：
     *      求旋转数组中的最小的元素。
     * 思路：二分法
     *      1. array[mid]一定是一边是升序，另一边是旋转数组
     *      2. min数字一定在旋转数组那边
     * */
    public static int minNumberInRotateArray(int [] array) {
        if (array==null || array.length == 0)
            return 0;
        int high = array.length-1, low = 0;
        int mid = (high + low) / 2;
        while (low < high){
            if (array[mid] <= array[high])//说明min在左边
                high = mid;
            else //if (array[mid] >= array[low]) //说明min在右边
                low = mid+1;
            mid = (low + high) / 2;
        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,1,1,2,1};
        System.out.println(minNumberInRotateArray(array));
    }
}
