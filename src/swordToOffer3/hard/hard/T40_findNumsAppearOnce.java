package swordToOffer3.hard.hard;

public class T40_findNumsAppearOnce {

    /**
     * 题目：
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     *
     * 思路：
     * 一个数字与它自己异或是0，一个数字与0异或是其本身
     * */
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 0) {
            return;
        }
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[0];
            return;
        }
        int bitResult = 0;
        for (int i=0; i<array.length; i++) {
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
    }

    /**
     * 找到一个数字中的二进制的1第一次出现得位置
     *
     * 不懂
     * */
    private static int findFirst1(int bitResult){
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>=1;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        int first1 = findFirst1(2);
        System.out.println(first1);
        System.out.println(2&1);

    }

}
