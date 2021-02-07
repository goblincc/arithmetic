package com.offer.exercise;

public class CompressString {
    public static void main(String[] args) {
        System.out.println(new CompressString().compressString("aabbbccddddde"));
    }

    public String compressString(String str){
        if(str == null){
            return null;
        }
        char temp = str.charAt(0);
        int cnt = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if(temp == str.charAt(i)){
                cnt++;
            }else{
                res.append(temp);
                res.append(cnt);
                temp = str.charAt(i);
                cnt = 1;
            }

        }
        res.append(temp);
        res.append(cnt);
        return res.toString();
    }
}
