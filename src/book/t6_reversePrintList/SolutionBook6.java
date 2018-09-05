package book.t6_reversePrintList;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author zxf
 * @date 2018/8/28 9:54
 */
public class SolutionBook6 {
    /**
     * 递归的方法：
     *      可能出现的问题：调用的层数太多导致函数调用栈溢出
     * */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode!=null){
            printListFromTailToHead(listNode.next);
            ans.add(listNode.val);
        }
        return ans;
    }

    /**
     * 用栈的方法，后进先出，循环遍历即可
     * */
    public void printListFromTailToHead2(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //输出栈
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    /**
     * 栈：
     *      JavaStack类：栈是Vector的一个子类，它实现了一个标准的后进先出的栈
     *      堆栈只定义了默认的构造函数，用来创建一个空栈。堆栈除了报错由Vector定义的所有方法，也定义了自己的一些方法。
     *      Stack()
     *      栈自己特有的方法：
     *          1. boolean empty()
     *              测试堆栈是否为空。
     *          2. Object peek()
     *              查看堆栈顶部的对象，但不从堆栈中移除它。
     *          3. Object pop()
     *              移除堆栈顶部的对象，并作为此函数的值返回该对象。
     *          4. Object push(Object element)
     *              把项压入堆栈顶部。
     *          5. int search(Object element)
     *              返回对象在堆栈中的位置，以 1 为基数
     * */

}
