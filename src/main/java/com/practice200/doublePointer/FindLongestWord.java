package com.practice200.doublePointer;

/**
 * Created by cc on 2020/8/3.
 * 最长子序列
 * Input:s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:"apple"
 * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，
 * 我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 */
public class FindLongestWord {
    public static void main(String[] args) {
        String s = "abpcplea";
        String[] target = new String[]{"ale","apple","monkey","plea"};
        String longestWord = new FindLongestWord().findLongestWord(s, target);
        System.out.println(longestWord);
    }

    public String findLongestWord(String s , String[] target){
        String longestWord = "";
        for(String str: target){
            int l1 = longestWord.length();
            int l2 = str.length();
            if(l1 > l2 || (l1 == l2 && longestWord.compareTo(str) > 0)){
                continue;
            }
            if(isSubstr(s, str)){
                longestWord = str;
            }
        }
        return longestWord;
    }

    public Boolean isSubstr(String s, String target){
        int i = 0;
        int j = 0;
        while(i < s.length() && j < target.length()){
            if(s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
