package com.practice200.traceBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IpAdress {
    private List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new IpAdress().restoreIpAddresses("25525511135"));
    }
    public List<String> restoreIpAddresses(String s){
        if(s == null || s.length() == 0){
            return res;
        }
        LinkedList<String> track = new LinkedList<>();
        traceBack(s, s.length(), 0, 4, track);
        return res;
    }

    public void traceBack(String s, int len, int begin, int residue, LinkedList<String> track){
//        if(track.size() == 4){
//            if(residue == 0){
//                res.add(String.join(".", track));
//            }
//            return;
//        }
        //遍历完字符串，且所有段被分割，说明找到一个IPadress
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", track));
            }
            return;
        }
        for(int i = begin; i < begin + 3; i++){
            if(i >= s.length()){
                return;
            }
            //每段长度为3， 如果剩余长度大于剩余段数的长度，不可能组成有效IP

            if(len - i > residue * 3){
                continue;
            }
            if(isIpSegment(s, begin, i)){
                String seg = s.substring(begin, i + 1);
                track.addLast(seg);
                traceBack(s, len, i + 1, residue - 1, track);
                track.removeLast();
            }
        }
    }

    public boolean isIpSegment(String s, int left, int right){
        int len = right - left + 1;
        if(len > 1 && s.charAt(left) == '0'){
            return false;
        }
        int res = 0;
        while(left <= right){
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
