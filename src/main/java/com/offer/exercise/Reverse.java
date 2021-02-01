package com.offer.exercise;

/**
 * 反转单词顺序列
 * 双指针解法：
 * 1、先反转每个单词的顺序
 * 2、字符串整体反转
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(new Reverse().ReverseSentence("I am a student"));
    }
    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            //碰到空格或者末尾的时候确定一个单词， 反转这个单词的顺序
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                //反转完成后，慢指针跳到下个单词的初始位置
                i = j + 1;
            }
            j++;
        }
        //反转整个字符串序列
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
