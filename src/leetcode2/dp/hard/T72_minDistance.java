package leetcode2.dp.hard;

public class T72_minDistance {
    /**
     * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     * dp[i][j]代表从word1[0...i-1]转化为word2[0...j-1]的最小操作数
     *
     * dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
     * */
    private static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<=word1.length(); i++) {
            for (int j=0; j<= word2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }else if (j == 0) {
                    dp[i][j] = i;
                }else if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int minDistance = minDistance(word1, word2);
        System.out.println(minDistance);
    }
}
