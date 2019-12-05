package swordToOffer3;

public class T6_minNumInRotateArray {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * 思路：
     * 1. 二分法，需要考虑这是非递减排序，即有可能是全部一样的数字，这种情况怎么办
     * */
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length-1;
        int mid;
        while (low < high) {
            mid = (low+high) >> 1;
            if (array[mid] <= array[high]){

            }else {

            }
        }
        return -1;
    }
}
