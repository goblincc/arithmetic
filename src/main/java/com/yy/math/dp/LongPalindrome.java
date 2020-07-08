package com.yy.math.dp;

import java.util.Arrays;

/**
 * 最长回文子序列
 * 状态：双层遍历
 * dp数组含义，在子串s[i..j]中，最长回文子序列的长度为dp[i][j]
 * base case dp[i][i] = 1  对角线上的元素均为1， 当i>j dp[i][j] = 0
 * 观察 dp[i][j] 和dp[i - 1][j + 1]  向两边扩展， 注意遍历的方式
 * Created by Administrator on 2020/7/1.
 */
public class LongPalindrome {
    public static void main(String[] args) {
        String str = "bbbcabb";
        int palindrome = new LongPalindrome().palindrome2(str);
        System.out.println(palindrome);
    }

    /**
     * 从下向上，从左到右遍历
     * @param s
     * @return
     */
    public int palindrome(String s){
        if(s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = i + 1; j < n ; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 斜向遍历
     * @param s
     * @return
     */
    public int palindrome2(String s){
        if(s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n ; i++) {
                int j = k + i + 1;
                if( j < n){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }else{
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }

            }
        }
        return dp[0][n - 1];
    }
}
