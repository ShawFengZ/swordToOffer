package swordToOffer3;

import swordToOffer3.utils.ListNode;

import java.util.ArrayList;

public class T3_printListFromTail {
    /**
     * 题目：
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     *
     * 思路：
     * 1. 递归
     * 2. 栈
     * */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        printListFromTailToHeadUtils1(list, listNode);
        return list;
    }

    //思路1：递归
    private static void printListFromTailToHeadUtils1(ArrayList<Integer> list, ListNode listNode){
        if (listNode.next != null) {
            printListFromTailToHeadUtils1(list, listNode.next);
        }
        list.add(listNode.val);
    }
}
