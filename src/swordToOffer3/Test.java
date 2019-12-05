package swordToOffer3;


import swordToOffer3.utils.ListNode;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        test12();
        //test10();
        //test9();
        //test7();
        //test3();
        //test2();
        //test1();

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
