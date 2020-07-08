package com.yy.math;

import java.util.*;

/**
 * Created by Administrator on 2020/6/29.
 */
public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {

        final Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>(count.keySet());
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return count.get(a).equals(count.get(b)) ? a.compareTo(b) : count.get(b) - count.get(a);
            }
        });
        return res.subList(0, k);
    }
}
