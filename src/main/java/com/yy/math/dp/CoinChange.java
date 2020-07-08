package com.yy.math.dp;

import java.util.Arrays;

/**
 * dp(n)的定义，当前的目标金额是n，至少需要dp(n)个硬币凑出该金额。
 * Created by Administrator on 2020/7/6.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int i = new CoinChange().coinChange(coins, amount);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < m; j++) {
                if(i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return (dp[amount] == amount + 1) ? -1: dp[amount];
    }
}
