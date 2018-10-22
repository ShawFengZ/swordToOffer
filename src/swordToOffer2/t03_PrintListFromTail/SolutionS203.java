package swordToOffer2.t03_PrintListFromTail;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zxf
 * @date 2018/10/19 16:59
 */
public class SolutionS203 {
    /**
     * 从尾到头打印链表：
     * 思路一：递归
     * 思路二：栈
     * */
    static ArrayList<Integer> arrayList = new ArrayList<>();
    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode!=null){
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    //用一个栈来保存需要打印的链表的节点
    private static ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        //进栈
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //出栈
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ArrayList<Integer> integers = printListFromTailToHead2(head);
        for (Integer i: integers)
            System.out.print(i+" ");
    }
}
