package com.offer.exercise;

/**
 * Created by chenchang on 2021/2/9 11:32.
 */
public class QuickSort {

    public static void main(String[] args){
        int[] nums = new int[]{1,3,2,8,4};
        new QuickSort().quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void quickSort(int[] nums, int left , int right){
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        //定义基准数
        int base = nums[left];
        while(i < j){
            //注意以左侧数据为基准数， 先从右往左遍历
            while(nums[j] >= base && i < j){
                j--;
            }
            while(nums[i] <= base && i < j){
                i++;
            }
            if (i<j) {
               swap(nums, i, j);
            }
        }
        nums[left] = nums[i];
        nums[i] = base;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

}
