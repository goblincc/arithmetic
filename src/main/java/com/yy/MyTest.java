package com.yy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyTest {
    public static void main(String[] args) {
        String redisKeySuffix = "0-15";
        int size = 20;
        int hashSize = 80 / size;
        Set<Integer> keySet = new HashSet<>();
        String[] fields = redisKeySuffix.split(",");
        for (String f : fields) {
            try {
                int index = f.indexOf("-");
                if (index == -1) {
                    Integer s = Integer.valueOf(f);
                    keySet.add(s);
                } else {
                    String b = f.substring(0, index);
                    String e = f.substring(index + 1);
                    for (int i = Integer.valueOf(b); i <= Integer.valueOf(e); ++i) {
                        keySet.add(i / hashSize);
                    }
                }
            } catch (Exception e) {
            }
        }
        List<Integer> result = new ArrayList<>(keySet);
        System.out.println(1/20);
        System.out.println(1%80);
    }
}
