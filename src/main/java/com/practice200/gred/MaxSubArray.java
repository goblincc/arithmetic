package com.practice200.gred;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new MaxSubArray().maxSubArray(nums));

    }
    public int maxSubArray(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if(dp[i - 1] > 0){
                dp[i] = nums[i] + dp[i - 1];
            }else{
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
