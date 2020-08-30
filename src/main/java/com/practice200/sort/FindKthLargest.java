package com.practice200.sort;

import java.util.PriorityQueue;

/**
 * Created by cc on 2020/8/4.
 */
public class FindKthLargest implements Comparable<FindKthLargest>{
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums){
            pq.add(val);
        }
        int size = pq.size();
        for(int i = 0; i < size; i++){
            System.out.println(pq.poll());
        }
    }

    public static int  findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums){
            pq.add(val);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    @Override
    public int compareTo(FindKthLargest o) {
        return 0;
    }
}
