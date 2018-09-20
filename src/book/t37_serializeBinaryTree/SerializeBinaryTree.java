package book.t37_serializeBinaryTree;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author zxf
 * @date 2018/9/20 9:16
 */
public class SerializeBinaryTree {
    /**
     * 题目描述：
     *      请实现两个函数，分别用来序列化和反序列化二叉树
     * 思路：
     *      序列化：1. 使用前序遍历序列化
     *              2. 将空的地方补充特殊字符，比如$
     *      反序列化：
     * */
    public int index = -1;
    public String serialize(T37BinaryTreeNode root){
        StringBuilder s = new StringBuilder();
        if (root == null) {
            s.append("$, ");
            return s.toString();
        }
        s.append(root.value + ", ");
        s.append(serialize(root.left));
        s.append(serialize(root.right));
        return s.toString();
    }

    //反序列化
    public T37BinaryTreeNode deserialize(String str){
        index ++;
        String[] DLRseq = str.split(",");
        T37BinaryTreeNode leave = null;
        if (!DLRseq[index].equals("$")) {
            leave = new T37BinaryTreeNode(Integer.valueOf(DLRseq[index]));
            leave.left = deserialize(str);
            leave.right = deserialize(str);
        }
        return leave;
    }
}
