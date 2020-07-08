package com.yy.math;

/**
 * Created by Administrator on 2020/6/22.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
//        String s = "a";
//        System.out.println(new LengthOfLastWord().lengthOfLastWord2(s));
//
//        String num1 = "0123";
//        int i = num1.charAt(0) - '0';
//        System.out.println(i);
//        System.out.println(13/10);
        System.out.println('c' - 'a');
    }
    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        if(ss.length==0){return 0;}
        return ss[ss.length-1].length();
    }

    public int lengthOfLastWord2(String s) {
        if(s == null|| s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(s.charAt(i) == ' '){
                if(count == 0){
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}
