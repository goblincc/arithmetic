package com.offer.exercise;

/**
 * Created by chenchang on 2021/2/9 17:18.
 */
public class MinNumber {

    public String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, nums.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s:strs){
            res.append(s);
        }
        return res.toString();
    }

    public void quickSort(String[] strs, int left , int right){
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        String base = strs[left];
        while(i < j){
            while((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0 && i < j){
                j--;
            }
            while((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0 && i < j){
                i++;
            }
            if(i < j){
                swap(strs, i, j);
            }

        }
        strs[left] = strs[i];
        strs[i] = base;
        quickSort(strs, left, i - 1);
        quickSort(strs, i + 1, right);
    }

    private void swap(String[] strs, int i, int j){
        String s = strs[i];
        strs[i] = strs[j];
        strs[j] = s;
    }
}
