package book.t26_subStructureOfTree;
/**
 * @author zxf
 * @date 2018/9/10 10:54
 */
public class SolutionBook26 {
    /**
     *  题目描述
     *      输入两个二叉树A和B，判断B是不是A的子结构。
     *  思路
     *      1. 在树A中查找和B树根节点一值一样的节点(遍历二叉树)R
     *          递归或是循环(没有特殊要求一般使用递归)
     *      2. 判断A中以R为根节点的子树是不是和B有相同的结构
     * */
    public static boolean hasSubTree(t26BinaryTreeNode root1, t26BinaryTreeNode root2){
        boolean result = false;

        if (root1 != null && root2 != null){
            if (isEquals(root1.value, root2.value))
                result = DoesTree1HasTree2(root1, root2);
            if (!result)
                result = hasSubTree(root1.left, root2);
            if (!result)
                result = hasSubTree(root1.right, root2);
        }
        return result;
    }

    //第二步，递归遍历，判断子树结构是否相同, 判断树1中是否有树2
    private static boolean DoesTree1HasTree2(t26BinaryTreeNode root1, t26BinaryTreeNode root2){
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (!isEquals(root1.value, root2.value))
            return false;
        return DoesTree1HasTree2(root1.left, root2.left);
    }


    //判断两个节点的值是否相等, double类型的数判断是否相等的方法
    private static boolean isEquals(double num1, double num2){
        return num1 - num2 < 0.0000001 && num1 - num2 > -0.0000001;
    }

}
