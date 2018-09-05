package t3_fandaList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxf
 * @date 2018/8/11 14:06
 */
public class Solution {
    //递归超简单的版本
    ArrayList<Integer> ans = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode!=null){
            printListFromTailToHead(listNode.next);
            ans.add(listNode.val);
        }
        return ans;
    }
}
