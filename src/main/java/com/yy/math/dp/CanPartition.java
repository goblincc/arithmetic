package com.yy.math.dp;

/**
 * Created by Administrator on 2020/6/30.
 */
public class CanPartition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 4, 2};
        boolean b = new CanPartition().canPartition(nums);
        System.out.println(b);
    }
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int temp: nums){
            sum += temp;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = sum ; j >= 0; j-- ){
                if(j - nums[i] >= 0){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
