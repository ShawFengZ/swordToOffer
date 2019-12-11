package swordToOffer3.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class T27_permutation2 {

    private static ArrayList<String> permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        permutationHelper(str.toCharArray(), 0, res);

        //排序后输出
        Collections.sort(res);
        return res;
    }

    private static void permutationHelper(char[] chars, int i, ArrayList<String> res){
        if (i == chars.length-1) {
            res.add(String.valueOf(chars));
        } else {
            Set<Character> set = new HashSet<>();
            for (int j=i; j<chars.length; j++) {
                if (j==i||!set.contains(chars[j])) {
                    set.add(chars[j]);
                    swap(chars, i, j);
                    permutationHelper(chars, i+1, res);
                    swap(chars, i, j);
                }
            }
        }
    }

    private static void swap(char[] chars, int i, int j){
        Character tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
