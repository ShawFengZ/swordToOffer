package t6_minNumberInRotateArray;

/**
 * @author zxf
 * @date 2018/8/11 17:42
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        //不需要旋转回来，因我我们可以一直遍历直到开始减即可
        if (array.length==0)
            return 0;
        int min = array[0];
        for (int i=0; i<array.length; i++){
            if (array[i]<min){
                min = array[i];
                break;
            }
        }
        return min;
    }
}
