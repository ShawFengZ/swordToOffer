package swordToOffer3;

public class T28_moreThanHalfNum_Solution {

    /**
     *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     *
     * 思路：
     * num保存当前数字，cnt保存数字出现次数
     * 1. 如果当前数字与num相同，则cnt++'
     * 2. 如果当前数字与num不同，则cnt--;
     * 3. 如果cnt为0则更新num为当前数字，cnt=1;
     *
     * 4. 再遍历一次，判断刚刚得到的数是不是个数超过一半
     * */
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array.length <= 2) {
            return array[0];
        }
        int cnt = 1, num = array[0];
        for (int i=0; i<array.length; i++) {
            if (array[i] == num) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                num = array[i];
                cnt = 1;
            }
        }
        //检查num的个数
        cnt = 0;
        int total = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == num) {
                cnt++;
            }
            total++;
        }
        if (cnt * 2 > total) {
            return num;
        } else {
            return 0;
        }
    }
}
