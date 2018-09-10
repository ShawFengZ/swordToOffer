package book.t25_mergeSortedList;

/**
 * @author zxf
 * @date 2018/9/10 10:30
 */
public class SolutionBook25 {

    /**
     * 题目描述
     *      输入两个递增排序的链表，合并这两个链表并使新链表中的节点是递增排序的。
     * 思路：
     *      0. 判断初始条件，如果两个其中一个为空
     *      1. 设置两个指针，p1指向l1的头节点，p2指向l2的头节点
     *      2. 比较p1和p2指向的节点的大小，创建一个新的链表p3作为头
     *      3. 保存头节点，留待返回
     *      4. 依次往后处理，直到其中一条结束
     *      5. 将未结束的链表添加在新链表的最后
     * */
    public static t25ListNode mergeTwoSortedList(t25ListNode list1, t25ListNode list2){
        //鲁棒性
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        //创建两个指针
        //可以直接以list1和list2作为指针
        //创建第三条链表的头节点指针和遍历指针
        t25ListNode list3 = new t25ListNode();
        t25ListNode head = new t25ListNode();

        while (list1 != null && list2 != null){
            //比较两个大小
            if(list1.value < list2.value){
                list3 = list1;
                list1 = list1.next;
            }else {
                list3 = list2;
                list2 = list2.next;
            }
            if(head != list1 && head != list2){//说明是第一次比较，还没有设置头节点
                head = list3;
            }
        }
        //如果list1没有用完
        if(list1 != null){
            list3.next = list1;
        }
        if (list2 != null){
            list3.next = list2;
        }
        return head;
    }
}
