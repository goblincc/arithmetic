package com.offer.exercise;

/**
 * 左旋转字符串
 * 双指针解法：
 * 1、 分别反转以k为边界的两个字符串
 * 2、 反转整体字符串
 */
public class LeftRotateString {
    public static void main(String[] args) {
        System.out.println(new LeftRotateString().leftRotateString("abcXYZ", 3));
    }

    public String leftRotateString(String str, int k){
        int i = 0;
        int n = str.length();
        char[] chars = str.toCharArray();
        reverse(chars, i, k - 1);
        reverse(chars, k, n - 1);
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j){
        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
