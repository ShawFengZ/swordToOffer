package leetcode.t49_GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zxf
 * @date 2018/10/18 19:11
 */
public class Solution49 {
    /**
     * 单词组队：字母相同的是同一个
     * 思路：
     *      1. 就是找相似，遍历，然后在数组中找如果是相同的，就扔到list中并把index放进hashMap中
     *      2. 写一个子方法判断两个单词是否相同。
     * 以上可以解决，但是时间复杂度不允许。
     * */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, String> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        int i = 0;
        while (map.size() < strs.length) {
            List<String> listTemp = new ArrayList<>();
            if (!map.containsKey(i))
                listTemp.add(strs[i]);
            map.put(i, strs[i]);
            int j = i+1;
            while (j < strs.length) {//找类似的
                if (isMatch(strs[i], strs[j]) && !map.containsKey(j)) {
                    map.put(j, strs[j]);
                    listTemp.add(strs[j]);
                }
                j++;
            }
            if (listTemp.size() != 0)
                list.add(listTemp);
            i++;
        }
        return list;
    }

    //比较两个单词是否match
    public static boolean isMatch(String str1, String str2){
        if (str1.length() != str2.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        boolean flag = true;
        for (int i=0; i< str1.length(); i++){
            if (map.containsKey(str1.charAt(i))) {
                Integer integer = map.get(str1.charAt(i)) + 1;
                map.put(str1.charAt(i), integer);
            } else
                map.put(str1.charAt(i), 1);
        }
        for (int i=0; i< str2.length(); i++) {
            if (map.containsKey(str2.charAt(i))) {
                Integer integer = map.get(str2.charAt(i))-1;
                if (integer != 0)
                    map.put(str2.charAt(i), integer);
                else
                    map.remove(str2.charAt(i));
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
