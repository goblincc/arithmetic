package com.yy.math.KMP;

/**
 * Created by Administrator on 2020/6/24.
 */
public class Main {
    public static void main(String[] args) {
        String txt = "DSABABC";
        String pat = "ABA";
        KMP kmp = new KMP(pat);
        int search = kmp.search(txt);
        System.out.println(search);
    }
}
