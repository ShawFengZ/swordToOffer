package swordToOffer3;


import swordToOffer3.utils.ListNode;
import swordToOffer3.utils.RandomListNode;
import swordToOffer3.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        //test29();
        //test28();
        //test25();
        //test22();
        //test21();
        //test20();
        //test17();
        //test16();
        //test15();
        //test14();
        //test13();
        //test12();
        //test10();
        //test9();
        //test7();
        //test3();
        //test2();
        //test1();

        //test40();
        test37();
    }

    private static void test37(){
        int[] array = {1, 2, 2, 3, 3, 3};
        int i = T37_getNumberOfK.GetNumberOfK2(array, 3);
        System.out.println(i);
    }

    private static void test40(){
        int[] array = {1, 1, 2, 2, 3, 4};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        T40_findNumsAppearOnce.FindNumsAppearOnce1(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }


    private static void test29(){
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> integers = T29_getLeastNumbers_Solution.GetLeastNumbers_Solution(input, 4);
        System.out.println(integers);
    }

    private static void test28(){
        int[] array = {1,2,3,2,4,2,5,2,3};
        int i = T28_moreThanHalfNum_Solution.MoreThanHalfNum_Solution(array);
        System.out.println(i);
    }

    private static void test25(){
        RandomListNode pHead = new RandomListNode(1);
        pHead.next = new RandomListNode(2);
        pHead.next.next = new RandomListNode(3);
        pHead.next.next.next = new RandomListNode(4);
        pHead.next.random = pHead.next.next.next;
        RandomListNode clone = T25_randomListNodeClone.Clone(pHead);
        System.out.println(clone.label + " " +clone.next.label + " " +
                clone.next.next.label + " " + clone.next.next.next.label
                +" " + clone.next.random.label);
    }

    private static void test22(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        ArrayList<Integer> integers = T22_printFromTopToBottom.PrintFromTopToBottom(root);
        System.out.println(integers);
    }

    private static void test21(){
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        boolean b = T21_isPopOrder.IsPopOrder(pushA, popA);
        System.out.println(b);
    }

    private static void test20() {
        T20_minFunctionStack t20_minFunctionStack = new T20_minFunctionStack();
        t20_minFunctionStack.push(3);
        int min = t20_minFunctionStack.min();
        System.out.print(min + " ");
    }

    private static void test17(){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        boolean b = T17_hasSubtree.HasSubtree(root1, root2);
        System.out.println(b);
    }

    private static void test16(){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode merge = T16_merge.Merge(list1, list2);
        while (merge != null) {
            System.out.print(merge.val + " ");
            merge = merge.next;
        }
    }

    private static void test15(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        /*head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);*/
        ListNode listNode = T15_reverseList.ReverseList(head);
        while (listNode != null) {
            System.out.print(listNode.val + " " );
            listNode = listNode.next;
        }
    }

    private static void test14(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = T14_findKthToTail.FindKthToTail(head, 2);
        System.out.println(listNode.val);
    }

    private static void test13(){
        int[] array = {1, 2, 3, 4, 5};
        T13_reOrderArray.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    private static void test12(){
        double power = T12_power.Power(2, -3);
        System.out.println(power);
    }

    private static void test10(){
        int rectCover = T10_rectCover.RectCover(5);
        System.out.println(rectCover);
    }

    private static void test9(){
        int floorII = T9_JumpFloorII.JumpFloorII(3);
        System.out.println(floorII);
    }

    private static void test7(){
        int fibonacci = T7_fibonacci.Fibonacci(6);
        System.out.println(fibonacci);
    }

    private static void test3(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ArrayList<Integer> integers = T3_printListFromTail.printListFromTailToHead(head);
        System.out.println(integers);
    }

    private static void test2(){
        String s = "We Are Happy.";
        StringBuffer sb = new StringBuffer(s);
        String s1 = T2_replaceSpace.replaceSpace(sb);
        System.out.println(s1);
    }

    private static void test1(){
        int[][] array = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        boolean find = T1_findInMatrix.Find(8, array);
        System.out.println(find);
    }
}
