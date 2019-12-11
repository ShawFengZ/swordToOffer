package swordToOffer3.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T29_GetLeastNumbers_Solution {
    /**
     * 最小的k个数
     *
     * 用最大堆
     * */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k) {
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(11, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });

        for (int i=0; i<input.length; i++) {
            pq.offer(input[i]);
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
