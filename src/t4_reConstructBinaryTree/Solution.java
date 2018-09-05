package t4_reConstructBinaryTree;

import java.util.Arrays;

/**
 * @author zxf
 * @date 2018/8/11 14:26
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length==0 || in.length==0)
            return null;
        //构建根节点
        TreeNode node = new TreeNode(pre[0]);
        for (int i=0; i<in.length; i++){
            if (pre[0] == in[i]){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return node;
    }
}
