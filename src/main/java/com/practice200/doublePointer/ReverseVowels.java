package com.practice200.doublePointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by cc on 2020/7/29.
 * 反转字符串中的元音字符
 * Given s = "leetcode", return "leotcede".
 */
public class ReverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        String s1 = new ReverseVowels().reverseVowels(s);
        System.out.println(s1);
    }
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    );

    public String reverseVowels(String s){
        if(s == null) return null;
        int i = 0;
        int j = s.length() - 1;
        char[] result = new char[s.length()];
        while(i < j){
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(!vowels.contains(left)){
                result[i++] = left;
            }else if(!vowels.contains(right)){
                result[j--] = right;
            }else{
                result[i++] = right;
                result[j--] = left;
            }
        }
        return new String(result);
    }
}
