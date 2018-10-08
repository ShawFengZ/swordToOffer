package book.t41_theMidInDataFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zxf
 * @date 2018/10/8 13:23
 */
public class SolutionBook41 {
    /**
     * 题目描述：
     *      如何得到一个数据流中的中位数。如果从数据流中读出奇数个数值，
     *      那么中位数就是所有数值排序后位于中间的数值，如果从数据流中
     *      读出来的是偶数个数值，就是中间两个数值的平均值。
     * 思路一：
     *      用一个List来放数据，O(1)
     *      查找中位数O(n)
     * 思路二：O(1) + O(logn)
     *      时间复杂度=插入的时间复杂度+选择的时间复杂度
     *      1. 用一个最大堆实现左边的数据容器，左边最大的数据会放在堆顶
     *      2. 用一个最小堆实现右边的数据容器，右边最小的数据会放在堆顶
     * */
    private ArrayList<Integer> arr = new ArrayList<>();
    //读入字符
    public void Insert(Integer num){
        arr.add(num);
    }

    //求中位数
    public Double getMidian(){
        Double middle = 0.0;
        int size = arr.size();
        while (size != 0) {
            Integer[] array = arr.toArray(new Integer[size]);
            Arrays.sort(array);
            if (size%2 == 0) {
                middle = (array[size/2-1] + array[size/2])/2.0;
            } else {
                int inx = size/2;
                middle =  array[inx]+0.0;
            }
        }
        return middle;
    }

    //思路二解法
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();//最大的数放在堆顶
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });//最小的数放在堆顶
    //读入字符，放到合适的位置
    public void insert(int num){
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    //求中位数
    public Double getMidian2(){
        if (count % 2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) /2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}
