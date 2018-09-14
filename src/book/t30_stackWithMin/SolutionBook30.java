package book.t30_stackWithMin;

import java.util.Stack;

/**
 * @author zxf
 * @date 2018/9/13 14:33
 */
public class SolutionBook30 {
    /**
     * 题目描述：
     *      定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的函数min.
     *      在该栈中调用min, push, pop的时间复杂度都是O(1)
     * 思路：
     *      1. 借助一个辅助栈将小元素存起来
     * */
    Stack<Integer> data = new Stack<Integer>();//存放元素的栈
    Stack<Integer> min = new Stack<Integer>();//存放最小元素的栈

    //push
    public void stackWithMinPush(int item){
        data.push(item);
        if (min.size() == 0 || item < min.peek()){
            min.push(item);
        }else {//保证了data和min中的元素的个数一样
            min.push(min.peek());
        }
    }

    //pop
    public int stackWithDataPop(){
        if (data.size() > 0){
            return data.peek();
        }
        return 0;
    }

    //min, 返回最小值但是不弹出
    public int stackWithDataMin(){
        if (data.size() > 0 && min.size() > 0){
            return min.peek();
        }
        return 0;
    }
}
