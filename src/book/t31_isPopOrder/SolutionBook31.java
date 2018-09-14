package book.t31_isPopOrder;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/9/13 15:15
 */
public class SolutionBook31 {
    /**
     * 题目描述:
     *      输入两个正数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。
     *      假设压入栈的数字均不相等
     * 思路：
     *      1. 第一个数组进行压栈，直到遇到第二个数组的第一个数
     *      2. 第一个数组
     * */
    public static Boolean isPopOrder(int[] num1, int[] num2){

        Stack<Integer> temp = new Stack<Integer>();
        int index1 = 0, index2 = 0;
        Boolean flag = true;
        while (index2 < num2.length && index1 < num1.length) {
            if (num1[index1] != num2[index2]) {
                if (temp.size()>0 && temp.peek() == num2[index2]){
                    temp.pop();
                    index2++;
                }else {
                    temp.push(num1[index1]);
                    index1++;
                }
            } else {
                index1++;
                index2++;
            }
        }
        if (index1 == num1.length){
            while (index2 < num2.length && temp.size() > 0) {
                if (num2[index2++] != temp.pop()){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
