package swordToOffer3;

import swordToOffer3.utils.RandomListNode;

public class T25_randomListNodeClone {
    /**
     * 题目描述：
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     *
     * 思路：
     * 1. 复制节点；
     * 2. 复制链接
     * 3. 拆分链表
     * */
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        RandomListNode q = pHead;
        //1. 复制节点
        while (q != null) {
            RandomListNode newNode = new RandomListNode(q.label);
            newNode.next = q.next;
            q.next = newNode;
            q = newNode.next;
        }
        //2. 复制random
        q = pHead;
        while (q != null) {
            if (q.random != null) {
                q.next.random = q.random.next;
            }
            q = q.next.next;
        }
        //3. 拆分, 注意这里的拆分
        q = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (q != null) {
            RandomListNode cloneNode = q.next;
            q.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            q = q.next;
        }
        return pCloneHead;
    }
}
