package com.yy.string;

/**
 * Created by Administrator on 2020/6/18.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abacddc";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
//        System.out.println("acddc".substring(0, 0));
        System.out.println(new LongestPalindrome().isPalindrome("acaaca"));
    }

    public String longestPalindrome(String s){
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindrome(String s, int l, int r){
        char[] ss = s.toCharArray();
        while(l >= 0 && r < s.length() && ss[r] == ss[l]){
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public boolean isPalindrome(String s){
        char[] ss = s.toCharArray();
        int left = 0;
        int right = ss.length - 1;
        for(int i = 0; i < ss.length/2; i++){
            if(ss[left] == ss[right] && left <= right){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
