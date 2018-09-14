package book.t33_verifySequenceOfBST;

import java.util.Arrays;

/**
 * @author zxf
 * @date 2018/9/14 13:43
 */
public class SolutionBook33 {
    /**
     * 题目描述：
     *      输入一个正数数组，判断该数组是不是某二叉搜索树的后序遍历结果；
     *      如果是，则返回true，否则返回false.
     * 思路：
     *      1. 二叉搜索树，左子树小于根节点的值，右子树大于根节点的值；
     *      2. 根节点在后序遍历的最后一个节点
     *      3. 对左右子树分别判断
     * */
    public static Boolean verifySequenceOfBST(int[] arr, int length){
        if (arr == null || length == 0) {
            return false;
        }
        //找到左子树和右子树的分界
        int i = 0;
        for (; i< length-1; i++){
            if (arr[i] > arr[length -1])
                break;
        }
        //判断右子树中是否有小于根节点的值
        int j = i;
        for (; j < arr.length-1; j++) {
            if (arr[j] < arr[length-1])
                return false;
        }
        //判断左子树是否是二叉搜索树
        boolean left = true;
        //如果i=1，就当它是二叉搜索树
        if (i > 1){
            left = verifySequenceOfBST(Arrays.copyOfRange(arr, 0, i), i);
        }
        //判断右子树是否是二叉搜索树
        boolean right = true;
        if (i < length-2) {
            right = verifySequenceOfBST(Arrays.copyOfRange(arr, i, length-1), length-i-1);
        }
        return left && right;
    }

}
