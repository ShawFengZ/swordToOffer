package leetcode3.page10.middle;

import java.util.ArrayList;
import java.util.List;

public class Solution220 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for(int i=0; i<nums.length; i++){
            for(int j=1; j<= k && i+j < nums.length; j++) {
                if (Math.abs((long)nums[i]-(long)nums[i+j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * [2147483647,-2147483647]
     * 1
     * 2147483647
     * */
    public static void main(String[] args) {
        int[] nums = {2147483647,-2147483647};
        boolean duplicate = containsNearbyAlmostDuplicate(nums, 1, 2147483647);
        System.out.println(duplicate);
    }
}

class Solution{

    public List<String> summaryRanges(int[]nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        int start = 0, end = 0;
        int i=0;
        while (i < nums.length) {
        start = i;
        while(i < nums.length-1 && nums[i+1] == nums[i] + 1) {
        i++;
        }
        end = i;
        StringBuilder tmp = new StringBuilder();
        if (start == end) {
            tmp.append(nums[start]);
        } else {
            tmp.append(nums[start]);
            tmp.append("->");
            tmp.append(nums[end]);
        }
        list.add(tmp.toString());
        i++;
        }
        return list;
    }
}
