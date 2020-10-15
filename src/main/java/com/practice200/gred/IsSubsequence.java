package com.practice200.gred;

/**
 * 判断是否为子序列
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "adcbc";
        System.out.println(new IsSubsequence().isSubsequence(str1, str2));
        System.out.println(new IsSubsequence().isSubsequence2(str1, str2));
        System.out.println(new IsSubsequence().isSubsequence3(str1, str2));
        System.out.println("abc".indexOf('a',0));

    }

    /**
     * 按顺序查找字符是否存在
     * @param str1
     * @param str2
     * @return
     */
    public boolean isSubsequence( String str1, String str2){
        int index = -1;
        for(char c: str1.toCharArray()){
            index = str2.indexOf(c, index + 1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针算法
     * @param str1
     * @param str2
     * @return
     */
    public boolean isSubsequence2( String str1, String str2){
        int index_1 = 0;
        int index_2 = 0;
        while(index_1 < str1.length() && index_2 < str2.length()){
            if(str1.charAt(index_1) == str2.charAt(index_2)){
                index_1++;
            }
            index_2++;
        }
        return index_1 == str1.length();
    }

    /**
     * 动态规划算法
     * @param str1
     * @param str2
     * @return
     */
    public boolean isSubsequence3(String str1, String str2){
        if(str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return false;
        }
        int m = str1.length();
        int n = str2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = true;
        }
        for(int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }

            }
        }
        return dp[m][n];
    }
}
