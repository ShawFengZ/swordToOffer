package t28_moreThanHalfNum_Solution;

import java.util.Arrays;

/**
 * @author zxf
 * @date 2018/8/11 22:35
 */
public class Solution28 {
    public int moreThanHalfNum_Solution(int [] array) {
        //int[] newArray = new int[array.length];
        Arrays.sort(array);
        int count = 1;
        int flag = array[0];
        for (int i =1; i<array.length; i++){
            if (array[i] == flag){
                count++;
            }else {
                if (count > array.length/2){
                    break;
                }else {
                    flag = array[i];
                    count = 1;
                }
            }
        }
        if (count > array.length/2)
            return flag;
        else
            return 0;
    }
}
