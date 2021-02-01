package com.offer.exercise;

/**
 * 删除链表中重复的节点
 * 递归调用
 */
public class DeleteDuplication {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode next = pHead.next;
        if(pHead.val == next.val){
            while(next != null && pHead.val == next.val){
                    next = next.next;
            }
            return deleteDuplication(next);
        }else{
            pHead.next = deleteDuplication(next);
        }
        return pHead;
    }
}
