package leetcode3.page2.easy;

import java.util.ArrayList;
import java.util.List;

public class T26_removeDuplicates {

    /**
     * 删除排序数组的重复项
     *
     * 打败100%的提交
     * */
    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            while (i < nums.length-1 && nums[i] == nums[i+1]) {
                i++;
            }
            nums[index++] = nums[i];
        }
        return index;
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) {
            return res;
        }
        generate(res, "", 0, 0, n);
        return res;
    }

    private void generate(List<String> res, String tmp, int cnt1, int cnt2, int n){
        if(cnt1 > n || cnt2 > n) {
            return;
        }
        if(cnt1 == n && cnt1 == n) {
            res.add(tmp);
        }
        if(cnt1 >= cnt2) {
            generate(res, tmp+"(", cnt1+1, cnt2, n);
            generate(res, tmp+")", cnt1, cnt2+1, n);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i=0; i<len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
