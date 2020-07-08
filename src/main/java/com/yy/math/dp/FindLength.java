package com.yy.math.dp;

import com.yy.math.KMP.Main;

/**
 * 最长重复子数组
 * 方法一：滑动窗口
 * 方法二：动态规划
 * Created by Administrator on 2020/7/6.
 */
public class FindLength {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        int length = new FindLength().findLength2(A, B);
        System.out.println(length);
    }
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int len = Math.min(m - i, n);
            int maxLen = maxLen(A, B, i, 0, len);
            res = Math.max(res, maxLen);
        }

        for (int i = 0; i < n; i++) {
            int len = Math.min(n - i, m);
            int maxLen = maxLen(A, B, 0, i, len);
            res = Math.max(res, maxLen);
        }
        return res;
    }

    public int maxLen(int[] A, int[] B, int addA, int addB, int len ){
        int k = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if(A[addA + i] == B[addB + i]){
                k++;
            }else{
                k = 0;
            }
            res = Math.max(k, res);
        }
        return res;
    }

    public int findLength2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

}
