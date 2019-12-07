package swordToOffer3;

import java.util.ArrayList;

public class T42_findNumbersWithSum {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
     * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2) {
            return res;
        }
        int low = 0, high = array.length-1;
        int curL=Integer.MIN_VALUE, curH=Integer.MAX_VALUE;
        int curMax = Integer.MAX_VALUE;
        boolean flag = false;
        while (low < high) {
            if (array[low] + array[high] == sum) {
                flag = true;
                if (array[low] * array[high] < curMax) {
                    curL = array[low];
                    curH = array[high];
                    curMax = array[low] * array[high];
                }
                low++;
                high--;
            } else if (array[low] + array[high] < sum) {
                low++;
            } else {
                high--;
            }
        }
        if (flag) {
            res.add(curL);
            res.add(curH);
        }
        return res;
    }
}
