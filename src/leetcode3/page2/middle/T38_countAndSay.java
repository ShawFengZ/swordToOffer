package leetcode3.page2.middle;

public class T38_countAndSay {

    /**
     * 外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前
     * 一项的描述。前五项如下：
     * */
    private static String countAndSay(int n) {
        if (n < 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String res = "11";
        for (int i=2; i<n; i++){
            String tmp = "";
            int cnt = 0;
            for(int j=0; j<res.length(); j++){
                cnt++;
                if(j==res.length()-1 || res.charAt(j) != res.charAt(j+1)) {
                    tmp += cnt + res.charAt(j);
                    cnt = 0;
                }
            }
            res = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        String say = countAndSay(5);
        System.out.println(say);
    }
}
