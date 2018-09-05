package book.t11_rotateArray;

/**
 * @author zxf
 * @date 2018/8/30 15:16
 */
public class SolutionBook11 {

    /**
     * 题目描述：
     *      把一个排序好的数组的若干元素搬到队尾，就是旋转数组，目标是找出数组中的最小元素
     * */

    /**
     * 1. 顺序遍历：时间复杂度: O(n), 不符合面试官的考察需求
     *      要考虑：1，2，3，4，5也是旋转数组，是将0个元素搬到前面去
     * */
    public static int minInRotateArray1(int[] arr){
        if (arr[0] < arr[arr.length-1])
            return arr[0];
        for (int i=1; i< arr.length; i++){
            if (arr[i] < arr[i-1])
                return arr[i];
        }
        return -1;
    }

    /**
     * 2. 折半查找
     *      正常的旋转：arr[0]>=arr[arr.length-1]一定成立，此时折半，
     *                  如果arr[mid]>=arr[0],则在前半部分，high=mid
     *                  如果arr[mid]<=arr[arr.length],则在后半部分，low=mid
     *                  循环停止的条件：high-low=1, high指向的元素就是最小元素
     *      非正常旋转：1. 旋转0个元素到前面
     *                  2. 大部分元素相等，就只能用遍历了
     * */
    public static int minInRotateArray2(int[] arr){
        if (arr.length<=0)
            return -1;
        int low = 0, high = arr.length-1;
        int mid = low;
        while (arr[low]>=arr[high]){
            if (high-low==1){//循环终止的条件
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            //如果下标为low,mid,high的数值都相等，只能用顺序遍历了
            if (arr[mid] == arr[low] &&
                    arr[mid] == arr[high])
                return minInRotateArray1(arr);
            if (arr[mid] >= arr[low])//在前半部分
                high = mid;
            if (arr[mid] <= arr[high])//在后半部分
                low = mid;
        }
        return arr[mid];
    }
}
