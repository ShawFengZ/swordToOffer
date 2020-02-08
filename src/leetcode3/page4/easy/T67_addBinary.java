package leetcode3.page4.easy;

public class T67_addBinary {

    private static String addBinary(String a, String b) {
        int index1 = a.length()-1;
        int index2 = b.length()-1;
        int jw = 0;
        String res = "";
        while(index1 >= 0 && index2 >= 0) {
            int aTmp = a.charAt(index1--) - '0';
            int bTmp = b.charAt(index2--) - '0';
            int sumTmp = aTmp + bTmp + jw;
            res = sumTmp%2 + res;
            if (sumTmp >= 2) {
                jw = 1;
            } else {
                jw = 0;
            }
        }
        //System.out.println(res);
        while(index1 >= 0) {
            int tmp = a.charAt(index1--) - '0';
            int sumTmp = tmp + jw;
            res = sumTmp%2 + res;
            if (sumTmp >= 2) {
                jw = 1;
            } else {
                jw = 0;
            }
        }
        while(index2 >= 0){
            int tmp = b.charAt(index2--) - '0';
            int sumTmp = tmp + jw;
            res = sumTmp%2 + res;
            if (sumTmp >= 2) {
                jw = 1;
            } else {
                jw = 0;
            }
        }
        if (jw > 0) {
            res = jw + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = addBinary("11", "1");

        System.out.println(s);
    }
}
