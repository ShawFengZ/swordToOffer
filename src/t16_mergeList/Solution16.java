package t16_mergeList;

import java.util.List;

/**
 * @author zxf
 * @date 2018/8/11 21:40
 */
public class Solution16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode list = null;
        ListNode head = null;
        if (list1.val<list2.val){
            head = list1;
            list1 = list1.next;
        }else {
            head = list2;
            list2 = list2.next;
        }
        head.next = list;
        while (list1!=null && list2!=null){//当两个联表均不空，需要比较来判断
            if (list1.val<=list2.val){
                list = list1;
                list1 = list1.next;
            }else {
                list = list2;
                list2 = list2.next;
            }
            list = list.next;
        }
        if (list1 != null){
            list = list1;
        }else if (list2!=null){
            list = list2;
        }
        return head;
    }

    //递归版本
    public ListNode Merge2(ListNode list1,ListNode list2){
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val){
            list1.next = Merge2(list1.next, list2);
            return list1;
        }else {
            list2.next = Merge2(list1, list2.next);
            return list2;
        }
    }

    //非递归版本
    public ListNode Merge3(ListNode list1,ListNode list2){
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode mergeHead = null;
        ListNode currentNode = null;
        while(list1!=null && list2!=null){
            if (list1.val<list2.val){
                //自己的代码这里缺少一步判断当前头指针是否为空的操作
                if (mergeHead == null){
                    mergeHead = currentNode = list1;
                }else {//这里自己的逻辑也没有理清楚
                    currentNode.next = list1;
                    currentNode = currentNode.next;
                }
                list1 = list1.next;
            }else {
                if (mergeHead == null){
                    mergeHead = currentNode = list2;
                }else {
                    currentNode.next = list2;
                    currentNode = currentNode.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 != null){
            currentNode.next = list1;
        }
        if (list2 != null){
            currentNode.next = list2;
        }
        return mergeHead;
    }
}
