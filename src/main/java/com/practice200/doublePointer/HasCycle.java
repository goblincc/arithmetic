package com.practice200.doublePointer;

/**
 * Created by cc on 2020/8/2.
 * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇
 */
public class HasCycle {
    public Boolean hasCycle(ListNode head){
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != null && fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
