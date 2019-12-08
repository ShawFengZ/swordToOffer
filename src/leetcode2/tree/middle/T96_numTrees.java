package leetcode2.tree.middle;

public class T96_numTrees {

    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * 思路：
     * 动态规划.
     *  假设n个节点存在二叉树个数为G(n), 令f(n)为以i为根的二叉搜索树的个数。
     *  G(n) = f(1) + f(2) + ...+ f(n)
     *
     *  左子树的节点数是i-1， 右子树的节点数是n-i, 因此f(i) = G(i-1)*G(n-i)
     *
     *  综上：
     *      G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     * */
}
