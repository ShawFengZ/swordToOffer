package category.tree_common;

/**
 * @author zxf
 * @date 2018/8/28 10:27
 * 对数操作的一些公共方法
 */
public class BinaryTree {

    /**
     * @Author zxf
     * @Description
     * @params 二叉树的节点
     * @return 输出节点的值
    */
    public static void printNode(Node node){
        if (node==null)
            return;
        System.out.print(node.getData()+" ");
    }

    public static Node createBinaryTree(){
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;   //返回根节点
    }
}
