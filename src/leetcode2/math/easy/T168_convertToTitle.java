package leetcode2.math.easy;

public class T168_convertToTitle {
    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     *
     *  其实就是26进制数
     * */
    private static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n >= 26) {
            sb.append(getChar(n/26));
            n %= 26;
        }
        sb.append(getChar(n));
        return sb.toString();
    }

    private static char getChar(int n){
        switch (n){
            case 1: return 'A';
            case 2: return 'B';
            case 3: return 'C';
            case 4: return 'D';
            case 5: return 'E';
            case 6: return 'F';
            case 7: return 'G';
            case 8: return 'H';
            case 9: return 'I';
            case 10: return 'J';
            case 11: return 'K';
            case 12: return 'L';
            case 13: return 'M';
            case 14: return 'N';
            case 15: return 'O';
            case 16: return 'P';
            case 17: return 'Q';
            case 18: return 'R';
            case 19: return 'S';
            case 20: return 'T';
            case 21: return 'U';
            case 22: return 'V';
            case 23: return 'W';
            case 24: return 'X';
            case 25: return 'Y';
            case 26: return 'Z';
            default: return '*';
        }
    }

    /**
     * 简要做法
     * */
    public static String convertToTitle2(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)(n%26 + 'A'));
            n = n/26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String convertToTitle = convertToTitle2(52);
        System.out.println(convertToTitle);
    }
}
