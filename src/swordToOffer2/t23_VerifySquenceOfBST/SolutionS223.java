package swordToOffer2.t23_VerifySquenceOfBST;

/**
 * @author zxf
 * @date 2018/10/24 8:59
 */
public class SolutionS223 {
    /**
     * 题目描述：
     *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     *      如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * 思路：
     *      1. 二叉搜索树，左子树的节点比根节点小，右子树的节点比根节点大，不要忽视。
     *      2. 递归做判断，start,end, sequence
     * */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return VerifySquenceOfBST(sequence, 0,sequence.length-1);
    }

    private static boolean VerifySquenceOfBST(int[] sequence, int start, int end){
        if (start >= end)
            return true;
        /*if (start > end)
            return false;*/
        int index = 0;
        while (sequence[index] < sequence[end])
            index++;
        if (sequence[index] >= sequence[end] && index > 0)
            index--;
        int index2 = index+1;
        while (index2 < end) {
            if (sequence[index2] < sequence[end]) {
                return false;
            } else {
                index2++;
            }
        }
        return VerifySquenceOfBST(sequence, start, index)
                && VerifySquenceOfBST(sequence, index+1, end-1);
    }

    public static void main(String[] args) {
        int[] sequences = {7,4,6,5};
        boolean b = VerifySquenceOfBST(sequences);
        System.out.println(b);
    }
}
