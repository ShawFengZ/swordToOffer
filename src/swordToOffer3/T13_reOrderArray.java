package swordToOffer3;

public class T13_reOrderArray {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的
     * 后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
     *
     * 思路：
     * 1. 两个指针index1找奇数，index2固定住最后一个确定位置的数的位置
     * 2. 将index2到index1之间的数移动处理
     * 时间复杂度O(n^2)
     *
     * 上面这种做法的方式有点问题，还需要详细做一下
     * */
    public static void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int index1 = 0, index2 = 0;
        while (index1 < array.length) {
            while (index1 < array.length && array[index1]%2==1) {
                index1++;
            }
            index2 = index1;
            while (index2 < array.length && array[index2]%2==0) {
                index2++;
            }
            if (index2 > array.length) {
                break;
            }
            int tmp = array[index2];
            for (int i=index2; i>index1; i--) {
                array[i] = array[i-1];
            }
            array[index1] = tmp;
            index1 = index2;
        }
    }
}
