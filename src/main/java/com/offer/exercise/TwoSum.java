package com.offer.exercise;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 有序数组中找到和为target的两个数
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new TwoSum().twoSum(nums, 6));
    }
    public ArrayList<Integer> twoSum(int[] nums, int target){
        int i = 0; int j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                return new ArrayList<>(Arrays.asList(nums[i], nums[j]));
            }
            if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return new ArrayList<>();
    }
}
