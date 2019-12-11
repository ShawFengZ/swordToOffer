package swordToOffer3.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class T27_permutation {

    /**
     * 字符串的排列
     * */
    private static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        PermutationHelper(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private static void PermutationHelper(char[] chars, int i, ArrayList<String> list){
        if (i == chars.length-1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<>();
            for (int j=i; j<chars.length; ++j) {
                if (j == i || !charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i+1, list);
                    swap(chars, i, j);
                }
            }
        }
    }

    private static void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "abb";
        ArrayList<String> permutation = Permutation(str);
        System.out.println(permutation);
    }
}
