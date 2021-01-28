package com.other;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<Assemble, Integer> map = new HashMap<>();
        for(int i = 0; i < 3; i++){
            map.put(new Assemble(), i);
        }
        System.out.println(map.size());
    }
}
