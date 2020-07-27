package com.practice200.doublePointer;

/**
 * Created by cc on 2020/7/27.
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        int target = 10;
        boolean b = judgeSquareSum(target);
        System.out.println(b);
    }

    public static boolean judgeSquareSum(int target){
        int left = 0;
        int right = (int)Math.sqrt(target);
        while(left < right){
            int sum = left * left + right * right;
            if(sum == target){
                return true;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}
