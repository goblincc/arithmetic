package com.yy.math;

import java.util.HashMap;

/**
 * Created by Administrator on 2020/6/12.
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 2, -2, 4, 1};
//        int[] nums = new int[]{1, 1, 1};
        SubarraySum subarraySum = new SubarraySum();
        int i = subarraySum.subarraySum(nums, 5);
        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre_sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            pre_sum += nums[i];
            int sum_temp = pre_sum - k;
            if(map.containsKey(sum_temp)){
                res += map.get(sum_temp);
            }
            map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
        }
        return res;
    }
}
