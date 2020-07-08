package com.yy.math;

import java.util.HashMap;

/**
 * Created by Administrator on 2020/6/11.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 3, 6};
//        System.out.println(new TwoSum().twoSum(nums, 6)[1]);
        System.out.println(new TwoSum().twoSum2(nums, 6)[1]);
    }

    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{i, map.get(temp)};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int value = nums[left] + nums[right];
            if(value== target){
                return new int[]{left, right};
            }else if (value > target){
                right--;
            }else if(value < target){
                left++;
            }
        }
        return null;
    }
}
