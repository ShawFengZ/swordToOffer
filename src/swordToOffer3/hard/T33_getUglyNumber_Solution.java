package swordToOffer3.hard;

public class T33_getUglyNumber_Solution {
    /**
     * 丑数
     *
     * 丑数的计算方法
     * */
    public int GetUglyNumber_Solution(int index) {
        int[] res = new int[index];
        if (index <= 6) {
            return index;
        }
        res[0] = 1; res[1] = 2; res[2] = 3; res[3] = 4; res[4] = 5;
        for (int i=4; i <index; i++) {
            int m2 = getMn(res, i, 2);
            int m3 = getMn(res, i, 3);
            int m5 = getMn(res, i, 5);
            res[i] = Math.min(Math.min(m2, m3), m5);
        }
        return res[index-1];
    }


    private int getMn(int[] res, int i, int n){
        int m = 0;
        for (int j=0; j<i; j++) {
            m = res[j] * n;
            if (m > res[i-1]){
                break;
            }
        }
        return m;
    }
}
