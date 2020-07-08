package com.yy.math.dp;

/**
 * dp数组定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
 * base case 是i走完s1或j走完s2，dp[0][0..j] = j;  dp[0..i][0] = i;
 * 状态：s1和 s2的长度， 即双层for循环
 * Created by Administrator on 2020/7/1.
 */
public class EditDistance {
    public static void main(String[] args) {
        String s1 ="horse";
        String s2 = "ros";
        int i = new EditDistance().minDistance(s1, s2);
        System.out.println(i);

    }

    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }


    public int min(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }
}
