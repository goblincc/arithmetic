package com.practice200.dynamic;

public class Rob {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0 ; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }
}
