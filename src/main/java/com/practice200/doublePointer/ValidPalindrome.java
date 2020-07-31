package com.practice200.doublePointer;

/**
 * Created by cc on 2020/7/30.
 * 文字符串
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "abcca";
        Boolean a = validPalindrome(s);
        System.out.println(a);
    }

    public static Boolean validPalindrome(String s){
        for (int i = 0; i < s.length() - 1; i++) {
            int j = s.length() - 1;
            if(i < j){
                if(s.charAt(i) != s.charAt(j)){
                    return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
                }
            }
            i++;
            j--;
        }
        return true;
    }

    public static Boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
