package leetcode3.page1.easy;

public class T09_isPalindrome {
    /**
     * 判断一个数是否是回文数
     * */
    private static boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        StringBuilder sb = new StringBuilder(value);
        String string = sb.reverse().toString();
        return value.equals(string);
    }

    private static boolean isPalindrome2(int x){
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x%10==0) {
            return false;
        }
        int y = 0;
        int tmp = x;
        while (tmp != 0) {
            y = y*10+tmp%10;
            tmp /= 10;
        }
        return x==y;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome2(-101);
        System.out.println(palindrome);
    }
}
