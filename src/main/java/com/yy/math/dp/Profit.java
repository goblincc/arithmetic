package com.yy.math.dp;

import com.yy.math.KMP.Main;

/**
 * 状态转移方程：
 * dp[i][k][0..1]  在第i天持有（不持有），至今最多进行k次交易
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
 * Created by Administrator on 2020/7/2.
 */
public class Profit {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        int i = new Profit().maxProfit4(prices, fee);
        System.out.println(i);
    }

    /**
     * k 为无限次
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if(i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
            }else{
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][0];
    }


    /**
     * k=1
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if(n == 0)return 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if(i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
            }else{
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //dp[i-1][k-1][0]-prices[i] = dp[i-1][-1][0] - prices[i] = -prices[i]
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }
        return dp[n - 1][0];
    }

    /**
     * k次交易
     * k 超过数组的一半时相当于没有做限制，因为一次交易买进和卖出需要两天，
     * 数组长度为1时，只能买进或者保持不动，所以利润为0
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices, int k) {
        int n = prices.length;
        if(n == 0) return 0;
        if(n == 1) return 0;
        if(k > n/2){
            int[][] dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                if(i == 0){
                    dp[0][0] = 0;
                    dp[0][1] = -prices[0];
                }else{
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                }
            }
            return dp[n - 1][0];
        }
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k ; j++) {
                if(i == 0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                }else{
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][k][0];
    }


    /**
     * k 为无限次, 带手续费
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices, int fee) {
        int n = prices.length;
        if(n == 0)return 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if(i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
            }else{
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][0];
    }
}
