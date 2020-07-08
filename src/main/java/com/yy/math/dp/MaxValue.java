package com.yy.math.dp;

/**
 * 最大路径
 * Created by Administrator on 2020/7/7.
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //初始位置
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    //第一行只能往右走
                }else if(i == 0){
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                    //第一列只能往下走
                }else if(j == 0){
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                    //其他位置可以向右也可以向下走
                }else{
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
