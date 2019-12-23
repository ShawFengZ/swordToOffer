package leetcode2.dp.middle;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import leetcode2.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T95_generateTrees {
    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
     * */
    private static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i=start; i<= end; i++) {
            List<TreeNode> subLeftTree = generateTrees(start, i-1);
            List<TreeNode> subRightTree = generateTrees(i+1, end);
            for (TreeNode left: subLeftTree) {
                for (TreeNode right: subRightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
