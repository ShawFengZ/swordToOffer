package t30_findGreatestSumOfSubArray;

/**
 * @author zxf
 * @date 2018/8/11 23:00
 */
public class Solution30 {
    //暴力求解，时间复杂度是O(n*n)
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxSum = 0;
        int sum = 0;
        for (int i=0; i<array.length-1; i++){//从第一个元素开始求最大子字符串的和
            sum = 0;
            for (int j = i; j<array.length; j++){
                sum += array[j];
                if (sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 最优方法的思路O(n)
     *      1. 和最大的子序列的第一个元素一定是正数
     *      2. 因为元素有正有负，因此子序列的最大和一定大于0
     *      {6,-3,-2,7,-15,1,2,2}
     * */
    public int FindGreatestSumOfSubArray2(int[] array) {
        int maxSum = array[0];
        int curSum = array[0];
        for (int i=0; i<array.length; i++){
            curSum += array[i];
            if (curSum > maxSum){
                maxSum = curSum;
            }
            if (curSum < 0)
                curSum = 0;
        }
        return maxSum;
    }
}
