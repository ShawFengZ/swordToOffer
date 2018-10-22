package swordToOffer2.t13_ReOrderArray;

/**
 * @author zxf
 * @date 2018/10/22 13:48
 */
public class SolutionS213 {
    /**
     * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的
     * 后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * 奇数在前，偶数在后
     *
     * 思路：时间复杂度O(n),思路不对
     *      1. 两个index1, index2.往后移动，当index1遇到偶数就停下，index2遇到奇数两个就交换
     *      2. index2遇到奇数就不动，偶数就后移
     * 思路二：没有想到更好的办法。
     *      1. 先遍历一遍求取奇数的个数
     * */
    private static void reOrderArray(int [] array) {
        if (array.length == 0 || array.length == 1)
            return;
        int index1 = 0, index2 = 1;
        while (index1 <= index2 && index2 < array.length) {
            if (array[index1] % 2 == 0 && array[index2] % 2 == 1) {
                int temp = array[index1];
                array[index1] = array[index2];
                array[index2] = temp;
            }
            if (array[index1] % 2 == 1)
                index1++;
            if (array[index2] % 2 == 0)
                index2++;
        }

        for (int anArray : array)
            System.out.print(anArray + " ");
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        reOrderArray(array);
    }
}
