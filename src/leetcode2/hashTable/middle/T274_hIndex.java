package leetcode2.hashTable.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T274_hIndex {
    /**
     * H指数
     *
     * 使用map计数每个引用次数以上的文章篇数
     * */
    private static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        for (int i=0; i<citations.length; i++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }
        return 0;
    }
}
