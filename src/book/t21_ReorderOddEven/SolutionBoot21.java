package book.t21_ReorderOddEven;

/**
 * @author zxf
 * @date 2018/9/6 13:35
 */
public class SolutionBoot21 {

    /**
     * 21. 调整数组顺序使奇数位于偶数前
     *      输入一个正数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位
     *      于数组的前半部分，偶数位于数组的后半部分
     * 思路：
     *     1. 从数组的两头向中间遍历；
     *     2. 头的那部分，遇到奇数就后移，偶数就停下；
     *     3. 尾的那部分，遇到偶数就前移，奇数就停下；
     *     4. 当前面是偶数，后面是奇数的情况发生时，就交换两个数字
     *     时间复杂度O(n), 空间复杂度O(1)
     * */
    public static int[] reorderOddEven(int[] arr){
        if (arr==null || arr.length == 0)
            return null;
        int head = 0;
        int tail = arr.length - 1;
        while (tail != head && tail > head){
            if (arr[head] % 2 == 1){
                head++;
            }
            if (arr[tail] % 2 == 0){
                tail--;
            }
            if (arr[head] % 2 == 0 && arr[tail] % 2 == 1 && tail > head){
                int temp = arr[head];
                arr[head++] = arr[tail];
                arr[tail--] = temp;
            }
        }
        return arr;
    }
}
