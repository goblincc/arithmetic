package com.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenchang on 2021/2/22 17:44.
 */
public class ListTest {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> s = new LinkedList<>();
        s.add(2);
        list.add(s);
        s.removeLast();
        System.out.println(list);
    }
}
