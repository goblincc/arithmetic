package com.practice200.leetcode;

import java.util.LinkedList;

/**
 *  字符串压缩
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 */
public class CompressString {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(new CompressString().compressString(s));
        LinkedList<String> path = new LinkedList<>();
        path.addLast("aaa");
        path.addLast("bbb");
        System.out.println(String.join(".", path));
        System.out.println("abc".substring(1,1));
    }
    public String compressString(String s){
        if(s == null ){
            return null;
        }
        if(s.length() == 0){
            return s;
        }
        char ch = s.charAt(0);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(ch == s.charAt(i)){
                cnt++;
            }else{
                sb.append(ch);
                sb.append(cnt);
                ch = s.charAt(i);
                cnt = 1;
            }
        }
        sb.append(ch);
        sb.append(cnt);
        return s.length() > sb.toString().length() ? sb.toString() : s;
    }
}
