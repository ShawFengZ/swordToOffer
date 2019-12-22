package leetcode2.backtrack.middle;

import java.util.ArrayList;
import java.util.List;

public class T89_grayCode {
    /**
     * 格雷编码
     *
     * G(i) = i^(i/2)
     * */
    private static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i < 1<<n; ++i) {
            res.add(i ^ (i>>1));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = grayCode(2);
        System.out.println(list);

    }
}
