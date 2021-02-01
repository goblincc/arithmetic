package com.offer.exercise;


/**
 * 找出数组中重复的元素
 * 思路：
 *  1、比较numbers[i]和i的值，如果i与numbers[i]相等，也就是对数组排序后，numbers[i]就应该在对应的数组的第i个位置处，那么继续判断下一个位置。
 *  2、如果i和numbers[i]的值不相等，那么判断以numbers[i]为下标的数组元素是什么。
 *  2.1、如果numbers[numbers[i]]等于numbers[i]的话，那么就是说有两个相同的值了，重复了。找到了重复的数字
 *  2.2、如果numbers[numbers[i]]不等于numbers[i]的话，那么就将numbers[numbers[i]]和numbers[i]互换。继续进行1的判断。
 *  3、循环退出的条件是直至数组最后一个元素，仍没有找到重复的数字，数组中不存在重复的数字
 */
public class Duplicate {
    public static void main(String[] args){
        int[] nums = new int[]{2, 3, 0, 3, 5};
        new Duplicate().duplicate(nums);
        System.out.println(nums[0]);
    }

    public boolean duplicate(int[] nums){
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    nums[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
