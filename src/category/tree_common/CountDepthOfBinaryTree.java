package category.tree_common;

/**
 * @author zxf
 * @date 2018/8/29 10:38
 */
public class CountDepthOfBinaryTree {

    /**
     * @Author zxf
     * @Description  用递归的方式计算一棵二叉树的深度
     * @params 二叉树的根节点
     * @return 二叉树的深度
    */
    public static int level(Node root){
        if (root == null)
            return 0;
        return level(root.getLeftNode()) + 1 > level(root.getRightNode())? level(root.getLeftNode()) + 1
                :level(root.getRightNode())+1;
    }

    //第二种计算树的高度的方法，都是递归，这种思路帮助理解上更简单
    public static int treeDepth(Node root){
        if (root == null)
            return 0;
        if (root.getLeftNode() == null && root.getRightNode() == null)
            return 1;
        if (root.getLeftNode() == null)
            return treeDepth(root.getRightNode())+1;
        if (root.getRightNode() == null)
            return treeDepth(root.getLeftNode())+1;
        return max(treeDepth(root.getLeftNode()),treeDepth(root.getRightNode()))+1;
    }

    private static int max(int a, int b){
        return a>b?a:b;
    }
}
