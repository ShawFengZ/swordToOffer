package swordToOffer3.hard.hard;

public class T35_inversePairs {

    /**
     * 数组中的逆序对
     *
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
     * 即输出P%1000000007
     * */
    private static int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i=0; i<array.length; i++) {
            copy[i] = array[i];
        }
        return inversePairsCore(array, copy, 0, array.length-1);
    }

    private static int inversePairsCore(int[] array, int[] copy, int low, int high){
        if (low == high) {
            return 0;
        }
        int mid = (low + high)>>1;
        int leftCount = inversePairsCore(array, copy, 0, mid)%1000000007;
        int rightCount = inversePairsCore(array, copy, mid+1, high)%1000000007;

        return -1;//不是很懂
    }
}
