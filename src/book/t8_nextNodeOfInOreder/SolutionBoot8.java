package book.t8_nextNodeOfInOreder;

/**
 * @author zxf
 * @date 2018/8/30 10:39
 */
public class SolutionBoot8 {

    /**
     * 思路：
     *      1. 如果一个节点有右子树，那么它的下一个节点就是它的右子树的最左节点
     *      2. 一个节点没有右子树，如果节点是其父节点的左子节点，那么下一个节点就是其父节点
     *      3. 一个节点没有右子树，节点是其父节点的右子树，那么应该向上遍历，找到一个节点，这个节点是它父节点的左子节点
     * */
    public static Node getNextNode(Node root, Node aim){
        //先判断传入的参数是否正确
        if (root == null || aim == null)
            return null;
        //判断是否有右子树
        if (aim.right != null){
            Node node = aim.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }else {
            //判断是否是其父节点的左子节点
            if (aim.father.left == aim){
                return aim.father;
            }else {
                Node node = aim.father;
                while (node.father.left != node && node != root){
                    node = node.father;
                }
                if (node.father.left == node)
                    return node;
            }
        }
        return null;
    }
}
