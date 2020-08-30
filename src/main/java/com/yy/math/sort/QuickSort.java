package com.yy.math.sort;

/**
 * Created by Administrator on 2020/7/31.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,8,4};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void quickSort(int[] nums, int left, int right){
        if(left < right){
            int index = getIndex2(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    public static int getIndex(int[] nums, int left, int right){
        int pivotValue = nums[left];
        while(right > left){
            while (nums[right] <= pivotValue && right > left) {
                right--;
            }
            if (right > left) {
                nums[left] = nums[right];
                left++;
            }
            while (nums[left] >= pivotValue && right > left) {
                left++;
            }
            if (right > left) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[right] = pivotValue;
        return right;
    }


    public static int getIndex2(int[] nums, int left, int right){
        int temp = left;
        int pivotValue = nums[left];
        while(right > left){
            while (nums[right] <= pivotValue && right > left) {
                right--;
            }
            while (nums[left] >= pivotValue && right > left) {
                left++;
            }

            swap(nums, left, right);
        }
        swap(nums, temp, right);
        return right;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
