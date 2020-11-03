package com.practice200.gred;

public class CheckPossibility {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,3};
        System.out.println(new CheckPossibility().checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums){
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if(nums[i] >= nums[i - 1]){
                continue;
            }
            cnt++;
            if(i - 2 >= 0 && nums[i - 2] > nums[i]){
                nums[i] = nums[i - 1];
            }else{
                nums[i - 1] = nums[i];
            }
        }
        System.out.println(cnt);
        return cnt <= 1;
    }
}
