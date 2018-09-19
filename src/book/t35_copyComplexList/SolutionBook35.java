package book.t35_copyComplexList;

import java.util.Hashtable;

/**
 * @author zxf
 * @date 2018/9/19 15:07
 */
public class SolutionBook35 {
    /**
     * 题目描述:
     *      请实现函数ComplexListNode clone(ComplexListNode pHead)，复制
     *      一个复杂链表。在复杂链表中，每一个节点除了有一个next指向下一
     *      个节点，还有一个random指向任意节点或者空节点
     * 思路一：
     *      1. 复制每个节点，并用next连接起来
     *      2. 复制random指针，random指针可能在当前节点的前面也可能在当前节点的后面，
     *      因此要从头往后开始找，时间复杂度O(n^2)
     * 思路二：
     *      空间换时间，用O(n)的哈希表来存储，将时间复杂度降为O(n)
     * 思路三：
     *      1. 将节点A复制到A的后面；
     *      2. 复制random指针
     *      3. 将链表拆分成两个链表
     * */
    public ComplexListNode clone1(ComplexListNode head){
        //解法2
        if (head == null)
            return null;
        //复制链表
        ComplexListNode headClone = head;
        ComplexListNode p = head;
        //定义一个哈希表
        Hashtable<ComplexListNode, ComplexListNode> table = new Hashtable<>();
        while (p != null) {
            //将random指针保存起来
            table.put(p, p.random);
            p.next = head.next;
            head = head.next;
            p = p.next;
        }
        // 找到对应random节点
        p = headClone;
        while (p != null) {
            p.random = table.get(p);
            p = p.next;
        }
        return headClone;
    }

    /**
     * 1. 复制节点
     * */
    private void cloneNodes(ComplexListNode head){
        ComplexListNode p = head;
        while (p != null) {
            ComplexListNode pCloned = new ComplexListNode();
            pCloned.value = p.value;
            pCloned.next = p.next;
            pCloned.random = null;

            p.next = pCloned;
            p = pCloned.next;
        }
    }

    /**
     * 2. 连接random指针
     * */
    private void connectRandomNodes(ComplexListNode head){
        ComplexListNode p = head;
        while (p != null) {
            ComplexListNode pCloned = p.next;
            if (p.random != null) {
                pCloned.random = p.random.next;
            }
            p = pCloned.next;
        }
    }

    /**
     * 3. 将此链表拆分成两个链表
     * */
    private ComplexListNode reconnectNodes(ComplexListNode head){
        ComplexListNode p = head;
        ComplexListNode pClonedHead = null;
        ComplexListNode pClonedNode = null;

        if (p != null) {
            pClonedHead = pClonedNode = p.next;
            p.next = pClonedNode.next;
            p = p.next;
        }

        while (p != null) {
            pClonedNode.next = p.next;
            pClonedNode = pClonedNode.next;
            p.next = pClonedNode.next;
            p = p.next;
        }
        return pClonedHead;
    }
}
