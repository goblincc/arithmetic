package com.offer.exercise;

public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(new ReverseSentence().reverseSentence("I am a student"));
    }

    public String reverseSentence(String str){
        int n = str.length();
        int i = 0; int j = 0;
        char[] chars = str.toCharArray();
        while(j <= n){
            if(j == n || chars[j] == ' '){
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
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
