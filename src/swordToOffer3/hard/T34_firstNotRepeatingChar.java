package swordToOffer3.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class T34_firstNotRepeatingChar {
    /**
     * 第一个只出现一次的字符
     *
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
     * 中找到第一个只出现一次的字符,并返回它的位置, 如果
     * 没有则返回 -1（需要区分大小写）.
     *
     * 解法一：同时使用map和set
     * 解法二：使用list（行不通）
     * 解法三：使用ASCII码，打表法，最优解法
     * */
    private static int firstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                map.put(chars[i], i);
            } else if (map.containsKey(chars[i])){
                map.remove(chars[i]);
            }
        }
        if (map.size() == 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (Character c: map.keySet()) {
            if (map.get(c)<res) {
                res = map.get(c);
            }
        }
        return res;
    }

    private static int firstNotRepeatingChar2(String str){
        if (str == null || str.length() == 0) {
            return -1;
        }
        List<Character> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (!list.contains(chars[i])) {
                list.add(Character.valueOf(chars[i]));
            } else {
                list.remove(Character.valueOf(chars[i]));
            }
        }
        if (list.size() <= 0) {
            return -1;
        }
        return str.indexOf(list.get(0));
    }

    private static int firstNotRepeatingChar3(String str) {//打表法
        int[] words = new int[58];
        for(int i = 0;i<str.length();i++){
            words[((int)str.charAt(i))-65] += 1;
        }
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "googgle";
        int char2 = firstNotRepeatingChar(str);
        System.out.println(char2);

    }
}
