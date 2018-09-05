package t20_PrintFromTopToBottom;

import java.util.ArrayList;

/**
 * @author zxf
 * @date 2018/8/11 22:21
 */
public class Solution20 {
    //其实就是广度优先搜索, 广度优先搜索要借助队列的
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null){
            return null;
        }
        list.add(root.val);
        if (root.left!=null){
            PrintFromTopToBottom(root.left);
        }
        return list;
    }
}
