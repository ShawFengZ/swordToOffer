package book.t3_duplicateNumberInArr;


import java.util.Arrays;

/**
 * @author zxf
 * @date 2018/8/27 20:15
 */
public class Solution3 {

    /**
     * 最简单的方法：
     *      排序，然后遍历
     *      注意要引入依赖的工具包
     * */
    public boolean duplicate1(int numbers[], int length, int[] duplication){
        if (numbers == null || length < 2 || duplication ==null)
            return false;
        Arrays.sort(numbers);
        Boolean flag = false;
        int temp = numbers[0];
        for (int i=1; i<numbers.length; i++){
            if (temp == numbers[i]){
                flag = true;
                duplication[0] = temp;
                break;
            }else {
                temp = numbers[i];
            }
        }
        return flag;
    }

    /**
     * 推荐的方法
     *      打表的方法
     * */
    public boolean duplicate2(int numbers[], int length, int[] duplication){
        if (numbers == null || length < 2 || duplication ==null)
            return false;
        boolean flag = false;
        int i = 0;
        while(i<length){
            if (numbers[i] == i){
                i++;
                continue;
            }
            if (numbers[i] == numbers[numbers[i]]){
                flag = true;
                duplication[0] = numbers[i];
                break;
            }else {
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        return flag;
    }
}
