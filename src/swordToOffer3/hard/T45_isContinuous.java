package swordToOffer3.hard;

import java.util.Arrays;

public class T45_isContinuous {
    /**
     * 判断一个数组是否可以组成顺子，其中最多可以有4个0，0可以变换成任何数字
     *
     * 方法一：先排序，再依次计算和找
     * 方法二：
     *      max 记录 最大值
     *      min 记录  最小值
     *      min ,max 都不记0
     *      满足条件 1 max - min <5
     *                2 除0外没有重复的数字(牌)
     * */
    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        if (numbers.length == 1) {
            return true;
        }
        Arrays.sort(numbers);
        int cnt0 = 0;//计算0的个数
        for (int i=0; i<numbers.length-1; i++) {
            if (cnt0 > 4 || cnt0 < 0) {
                return false;
            }
            if (numbers[i] == 0) {
                cnt0++;
            } else {
                int tmp = numbers[i+1]-numbers[i];
                if (tmp == 0) {
                    return false;
                }
                tmp = tmp-1;
                cnt0 -= tmp;
            }
        }
        return cnt0>=0;
    }

    private static boolean isContinuous2(int[] numbers){
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int[] d = new int[14];
        d[0] = -5;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<numbers.length; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (d[numbers[i]] > 1) {
                return false;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        return max-min<5;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6};
        boolean continuous = isContinuous(numbers);
        System.out.println(continuous);
    }
}
