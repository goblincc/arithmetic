package com.practice200.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = new int[]{1,3,1,1,2,3,3,2,2};
        int k = 2;
        List<Integer> integers = topKFrequent.topKFrequent(nums, k);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
    public List<Integer> topKFrequent(int nums[], int k){
        Map<Integer, Integer> fre = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(fre.containsKey(nums[i])){
                fre.put(nums[i], fre.get(nums[i]) + 1);
            }else{
                fre.put(nums[i], 1);
            }
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(Integer key: fre.keySet()){
            int frequence = fre.get(key);
            if(bucket[frequence] == null){
                bucket[frequence] = new ArrayList<>();
            }
            bucket[frequence].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && topK.size() < k ; i--) {
            if(bucket[i] == null){
                continue;
            }
            if(bucket[i].size() <= (k - topK.size())){
                topK.addAll(bucket[i]);
            }else{
                topK.addAll(bucket[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }
}
