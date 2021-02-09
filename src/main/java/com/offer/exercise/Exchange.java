package com.offer.exercise;

import java.util.Arrays;

/**
 * Created by chenchang on 2021/2/9 10:29.
 */
public class Exchange {
    public static void main(String[] args){
        int[] exchange = new Exchange().exchange(new int[]{1, 4, 5, 6, 2, 3});
        for (int i = 0; i < exchange.length; i++) {
            System.out.println(exchange[i]);
        }
    }

    public int[] exchange(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            while(left < right && nums[left] % 2 != 0){
                left++;
            }
            while(left < right && nums[right] % 2 == 0){
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

}
