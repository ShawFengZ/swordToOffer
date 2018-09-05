import book.t10_fibonacci.SolutionBook10;
import book.t11_rotateArray.SolutionBook11;
import book.t12_pathInMatrix.SolutionBook12;
import book.t13_robotMoveArea.SolutionBook13;
import book.t14_cutRope.SolutionBook14;
import book.t6_reversePrintList.SolutionBook6;
import book.t7_rebuildBinaryTree.SolutionBook7;
import book.t8_nextNodeOfInOreder.Node;
import book.t9_2StackToQueue.SolutionBook9;
import category.bigNum_common.BigStringASMD;
import category.sort_common.SortMethod;
import category.sort_common.SortUtils;
import category.tree_common.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //2. 替换字符
        /*StringBuffer str = new StringBuffer("");
        Solution solution = new Solution();
        String ans = solution.replaceSpace(str);
        System.out.println(str);*/

        //4. 根据前序和中序重新构建树
        /*int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        Solution solution = new Solution();
        //TreeNode treeNode = solution.reConstructBinaryTree(pre, in);
        //System.out.println(treeNode.val);
        int[]  newArray = Arrays.copyOfRange(pre,0, 1);
        System.out.println(Arrays.toString(newArray));*/

        //6. 输出一个非递减旋转数组的旋转数组的最小值
        /*int[] array = {3, 4, 5, 6, 2};
        Solution solution = new Solution();
        System.out.println(solution.minNumberInRotateArray(array));*/

        //7. 斐波那契数列的第n项
        /*Solution7 solution7 = new Solution7();
        System.out.print(solution7.Fibonacci(0)+", ");
        System.out.print(solution7.Fibonacci(1)+", ");
        System.out.print(solution7.Fibonacci(2)+", ");
        System.out.print(solution7.Fibonacci(3)+", ");*/

        //8. 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
        //求该青蛙跳上一个n级的台阶总共有多少种跳法

        /**
         * 9. 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
         * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
         * */
        /*Solution9 solution9 = new Solution9();
        System.out.println(solution9.JumpFloorII(4));*/

        /**
         * 10. 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
         * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
         * */

        /**
         * 11. 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
         * */
        /*Solution11 solution11 = new Solution11();
        System.out.println(solution11.NumberOf1(20));*/
        //System.out.println(20%2);

        /**
         * 12. 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
         * */
        /*Solution12 solution12 = new Solution12();
        System.out.println(solution12.Power(2, -3));*/

        /**
         * 13. 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
         * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
         * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
         * */
        /*Solution13 solution13 = new Solution13();
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(solution13.reOrderArray(array)));*/

        /**
         * 14. 输入一个链表，输出该链表中倒数第k个结点。
         * */

        /**
         * 15. 输入一个链表，反转链表后，输出新链表的表头。反转链表
         * */

        /**
         * 16. 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
         * */

        /**
         * 17. 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
         * */

        /**
         * 20. 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
         * */

        /**
         * 28. 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
         * */
        /*Solution28 solution28 = new Solution28();
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(solution28.moreThanHalfNum_Solution(array));*/

        /**
         * 29. 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
         * */
        /*Solution29 solution29 = new Solution29();
        int[] array = {4,5,1,6,2,7,3,8};
        System.out.println(solution29.GetLeastNumbers_Solution(array, 10));*/

        /**
         *30. 求最大子序列
         * */
        /*Solution30 solution30 = new Solution30();
        //int[] array = {6,-3,-2,7,-15,1,2,2};
        int[] array = {-2,-8,-1,-5,-9};
        System.out.println(solution30.FindGreatestSumOfSubArray(array));
        System.out.println(solution30.FindGreatestSumOfSubArray2(array));*/


        /*
         * =================================书上的题目：=======================================
         * */
        /*Solution3 solution3 = new Solution3();
        int[] arrs = {2,3,1,0,2,5,3};
        int[] duplication = {0};
        //boolean b = solution3.duplicate1(arrs, arrs.length, duplication);
        boolean b = solution3.duplicate2(arrs, arrs.length, duplication);
        System.out.println(b);
        System.out.println(duplication[0]);*/
        /*Solution4 solution4 = new Solution4();
        int[] arr = {2,3,1,0,2,5,3};
        Integer duplication1 = solution4.getDuplication1(arr);
        System.out.println(duplication1);*/

        /**
         * 4. 二维数组中的查找
         * */
        /*Solution4 solution4 = new Solution4();
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Boolean inMatrix = solution4.isInMatrix(arr, 100);
        System.out.println(inMatrix);*/

        /**
         * 5. 替换字符串中的空格
         *  we are happy —> we%20are%20happy
         * */
        /*SolutionBook5 solutionBook5 = new SolutionBook5();
        char[] string = {'w','e',' ','a','r','e',' ','h','a','p','p','y'};
        String s = solutionBook5.replaceSpace1(string);
        for(int i=0;i<s.length();i++){
            System.out.print(s.charAt(i));
        }*/

        /**
         * =======================================二叉树的常用操作测试====================================================
         * */
        //创建一个二叉树
        //Node root = BinaryTree.createBinaryTree();
        /*//计算深度
        System.out.print("树的深度1：");
        System.out.println(CountDepthOfBinaryTree.level(root));
        System.out.print("树的高度2：");
        System.out.println(CountDepthOfBinaryTree.treeDepth(root));

        *//* 递归的前中后序遍历 *//*
        SolutionBookTreeRecursion solutionBookTreeRecursion = new SolutionBookTreeRecursion();
        //前序
        System.out.print("递归前序：");
        solutionBookTreeRecursion.theFirstTraversal(root);
        System.out.println();
        //中序
        System.out.print("递归中序：");
        solutionBookTreeRecursion.theInOrderTraversal(root);
        System.out.println();
        //后序
        System.out.print("递归后序：");
        solutionBookTreeRecursion.thePostOrderTraversal(root);
        System.out.println();

        *//* 非递归的千重后序 *//*
        SolutionBookTreeStack solutionBookTreeStack = new SolutionBookTreeStack();
        //前序
        System.out.print("非递归前序：");
        solutionBookTreeStack.theFirstTraversalStack(root);
        System.out.println();
        //中序
        System.out.print("非递归中序：");
        solutionBookTreeStack.theInOrderTraversal(root);
        System.out.println();
        //后序
        System.out.print("非递归后序：");
        solutionBookTreeStack.thePostOrderTraversalStack(root);
        System.out.println();

        *//* 层序遍历，广度优先搜索 *//*
        System.out.print("层序遍历：");
        solutionBookTreeStack.layerOrderTraversal(root);
        System.out.println();*/

        /*======== 二叉树广度深度优先搜索测试 ========*/
        /*System.out.print("广度优先搜索：");
        BinaryTreeSearch.printFromTopToBottom(root);
        System.out.println();
        System.out.print("深度优先搜索：");
        BinaryTreeSearch.printBinaryTreeDFS(root);*/

        /* ============================================十大经典排序算法测试================================================ */
        /*int[] arr = {10,3,15,2,6,4,7,79,22,4};
        System.out.print("未排序数：");
        SortUtils.printArr(arr);*/
        /*int[] arr1 = SortMethod.bubbleSort(arr);
        System.out.print("冒泡排序：");
        SortUtils.printArr(arr1);
        int[] arr2 = SortMethod.selectionSort(arr);
        System.out.print("选择排序：");
        SortUtils.printArr(arr2);*/
        /*int[] arr3 = SortMethod.insertionSort(arr);
        System.out.print("插入排序：");
        SortUtils.printArr(arr3);*/
        /*int[] shellSort = SortMethod.shellSort(arr);
        System.out.print("希尔排序：");
        SortUtils.printArr(shellSort);*/
        //简单的测试一下对两个数组的归并函数的使用
        /*int[] arr1={1,3,5,7,9};
        int[] arr2={2,4,6,7,10, 12, 13};
        int[] res = SortMethod.merge(arr1, arr2);
        SortUtils.printArr(res);*/
        /*int[] mergeSort = SortMethod.mergeSort(arr);
        System.out.print("归并排序：");
        SortUtils.printArr(mergeSort);*/
        /*int[] quickSort = SortMethod.quickSort(arr, 0, arr.length-1);
        System.out.print("快速排序：");
        SortUtils.printArr(quickSort);*/

        /* ================================================书上的题目================================================== */
        //7. 重构二叉树
        /*int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        book.t7_rebuildBinaryTree.Node node = SolutionBook7.reConstructBinaryTree(pre, in);
        System.out.println(node.left.getVal()+","+node.right.getVal());*/
        //8. 二叉树的下一个节点

        //9. 两个栈构成一个队列
        /*SolutionBook9 queue = new SolutionBook9();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        System.out.println(queue.pop()+","+queue.pop()+","+queue.pop()+","+queue.pop());*/

        //10. 斐波那契
        //递归
        /*System.out.print("递归：");
        System.out.println(SolutionBook10.fibonacci1(10));
        System.out.print("循环：");
        System.out.println(SolutionBook10.fibonacci2(100));//这个数字很大*/

        //11. 旋转数组
        //遍历
        //int[] arr = {5,6,1,2,3,4};
        //int[] arr = {1,2,3,4,5,6};
        /*int[] arr = {1,1,0,1,1,1};
        System.out.println("遍历："+SolutionBook11.minInRotateArray1(arr));
        System.out.println("折半："+SolutionBook11.minInRotateArray2(arr));*/
//        Double d1 = 1.2;
//        Double d2 = 1.2;
//        Integer i1 = 2;
//        Integer i2 = 2;
//        int ii1 = 3;
//        int ii2 = 3;
       // System.out.println(d1==d2);
       // System.out.println(i1==i2);
       // System.out.println(ii1==ii2);

        //12. 测试在矩阵中找路径
        /*char[] matrix = new char[]{'a', 'd', 'e', 'f', 'c', 'g','f','t','c','h','g','v'};
        //char[] str = {'g', 'd', 'e', 'f', 't'};
        char[] str = {'g', 'g', 'g'};
        int rows = 3;
        int cols = 4;
        boolean res = SolutionBook12.hasPath(matrix, rows,cols, str);
        System.out.println(res);*/

        //13. 测试机器人运动的范围大小
        /*int[] matrix = {};
        int rows = 4;
        int cols = 4;
        int k = 3;
        //int count = SolutionBook13.robotMoveAreaNum2(matrix, rows, cols, k);
        int count = SolutionBook13.robotMoveAreaNum(rows, cols, k);
        int count2 = SolutionBook13.robotMoveAreaNum2(rows,cols,k);
        System.out.println("count1:"+count);
        System.out.println("count2:"+count2);*/

        //14. 测试剪绳子，动态规划
        /*int maxProductAfterCutting = SolutionBook14.maxProductAfterCutting(8);
        System.out.println("最大长度："+maxProductAfterCutting);*/
        String num1 = "11111111112222222222222222222223333333333333333333333333454444455555555555555";
        String num2 = "12111111111111111111111111111111111111145454545454545454545454545454555454454";
//        BigInteger b1 = new BigInteger(num1);
//        BigInteger b2 = new BigInteger(num2);
//        //大整数加法
//        System.out.println("大数加法: " + b1.add(b2));
//        //大数减法
//        System.out.println("大数减法：" + b1.subtract(b2));
//        //大整数乘法
//        System.out.println("大数乘法: " + b1.multiply(b2));
//        //大数除法
//        System.out.println("大数除法：" + b1.divide(b2));

        String s = BigStringASMD.castSame(num1, 100);
        System.out.println(s);
    }
}
