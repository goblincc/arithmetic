package com.offer;

public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar("abac"));
    }

    public int FirstNotRepeatingChar(String str){
        int[] cnts = new int[128];
        for(int i = 0; i < str.length(); i++){
            cnts[str.charAt(i)]++;
        }
        for(int i = 0; i < str.length(); i++){
            if(cnts[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}
