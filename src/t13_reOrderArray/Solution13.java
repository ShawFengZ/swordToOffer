package t13_reOrderArray;

/**
 * @author zxf
 * @date 2018/8/11 19:12
 */
public class Solution13 {
    /**
     * 思路：先数清楚奇数和偶数的个数
     * */
    public int[] reOrderArray(int [] array) {
        int oddNum = countOddNum(array);
        int[] newArray = new int[array.length];
        int oddIndex = 0;
        int evenIndex = 0;
        //将奇数和偶数分别取出来放到新的数组里
        for (int i = 0; i < array.length; i++){
            if (array[i]%2==1){//奇数
                newArray[oddIndex++] = array[i];
            }else {//偶数
                newArray[oddNum+evenIndex++] = array[i];
            }
        }
        return newArray;
    }

    //计算偶数的个数
    private int countOddNum(int[] array){
        int count = 0;
        for (int num: array) {
            if (num%2==1){
                count++;
            }
        }
        return count;
    }
}
