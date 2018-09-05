package t29_getLeastNumbers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zxf
 * @date 2018/8/11 22:51
 */
public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if (k>input.length)
            return list;
        Arrays.sort(input);
        for (int i=0; i<k; i++){
            list.add(input[i]);
        }
        return list;
    }
}
