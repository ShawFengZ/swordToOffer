package swordToOffer3;

public class T1_findInMatrix {

    /**
     * 二维数组中查找：
     *
     * 题目：
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 思路：
     * 1. 从右往左比较，
     *      如果matrix[i][j]<target, 则在这一列；
     *      如果matrix[i][j]>target, 则列数左移；
     *      如果相等，返回true
     * */
    public static boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0)
            return false;
        int i=0, j=array[0].length-1;
        while (i<array.length && j>=0) {
            if (array[i][j] == target)
                return true;
            else if (array[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
