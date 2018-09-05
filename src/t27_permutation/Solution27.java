package t27_permutation;

import java.util.ArrayList;

/**
 * @author zxf
 * @date 2018/8/11 22:31
 */
public class Solution27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new  ArrayList<String>();

        if (!list.contains(str)){
            list.add(str);
        }
        return list;
    }
}
