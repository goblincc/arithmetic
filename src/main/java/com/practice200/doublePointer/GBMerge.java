package com.practice200.doublePointer;

/**
 * Created by cc on 2020/7/31.
 * 归并两个有序数组
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 */
public class GBMerge {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m , int[] nums2, int n){
        int index1 = m - 1;
        int index2 = n - 1;
        int indexMerge = m + n - 1;
        while(index1 >= 0 || index2 >= 0){
            if(index1 < 0){
                nums1[indexMerge--] = nums2[index2--];
            }else if(index2 < 0){
                nums1[indexMerge--] = nums1[index1--];
            }else if(nums1[index1] > nums2[index2]){
                nums1[indexMerge--] = nums1[index1--];
            }else{
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

}
