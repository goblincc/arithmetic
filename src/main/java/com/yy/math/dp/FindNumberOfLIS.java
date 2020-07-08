package com.yy.math.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最长递增子序列的个数
 * Created by Administrator on 2020/7/7.
 */
public class FindNumberOfLIS {
    public static void main(String[] args) {
        int[] nums = new int[]{100,90,80,70,60,50,60,70,80,90,100};
        int numberOfLIS = new FindNumberOfLIS().findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }
    public int findNumberOfLIS(int[] nums) {
        int m = nums.length;
        if(m == 0) return 0;
        int[] dp = new int[m];
        int[] counter = new int[m];
        Arrays.fill(counter, 1);
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        //对于组合是没有增加的，增加的是序列的长度
                        counter[i] = counter[j];
                        //当dp[j] + 1=dp[i]dp[j]+1=dp[i],说明这个长度已经找到过一次了
                    }else if(dp[i] == dp[j] + 1){
                        counter[i] += counter[j];
                    }
                }
            }
            //找到最长序列的长度
            max = Math.max(max, dp[i]);
        }

        int k = 0;
        for (int i = 0; i < m; i++) {
            if(dp[i] == max){
                k += counter[i];
            }
        }
        return k;
    }

}
