package swordToOffer3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T29_getLeastNumbers_Solution {
    /**
     * 最小k个数
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     *
     * 小顶堆，维持堆的大小为4
     * */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length < k) {
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i=0; i<input.length; i++) {
            pq.add(input[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (pq.size() > 0) {
            res.add(pq.poll());
        }
        return res;
    }
}
