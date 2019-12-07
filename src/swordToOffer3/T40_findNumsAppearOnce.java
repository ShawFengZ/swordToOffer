package swordToOffer3;

import java.util.HashSet;
import java.util.Set;

public class T40_findNumsAppearOnce {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。
     *
     * 异或：相异为1 相同为0
     * */
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

    }

    public static void main(String[] args) {
        System.out.println(4^2);
    }

    public static void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        Set<Integer> set= new HashSet<>();
        for (int i=0; i<array.length; i++) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }
        if (set.size() != 2){
            return;
        }
        int[] tmp = new int[2];
        int cnt = 0;
        for (Integer i: set) {
            tmp[cnt++] = i;
        }
        num1[0] = tmp[0];
        num2[0] = tmp[1];
    }


}
