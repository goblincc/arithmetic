package com.practice200.binary_search;

public class Binary_search {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,3,3,4};
        int target = 3;
        System.out.println(new Binary_search().binary_search(nums, target));
    }

    public int binary_search(int[] nums, int target){
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) /2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }
}
