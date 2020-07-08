package com.yy.math.dp;

/**
 * 最长公共子序列
 * dp[i][j]的定义：对于s1[1..i]和s2[1..j]，它们的 LCS 长度是dp[i][j]
 * 状态：s1和s2的长度，即双层for循环
 * basecase：索引为 0 的行和列表示空串，dp[0][..]和dp[..][0]都应该初始化为 0
 * 比如说，按照刚才 dp 数组的定义，dp[0][3]=0的含义是：对于字符串""和"bab"，其 LCS 的长度为 0
 * Created by Administrator on 2020/7/1.
 */
public class LongestCommonSequence {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcd";
        int i = new LongestCommonSequence().longestCommon(s1, s2);
        System.out.println(i);

    }
    public int longestCommon(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
