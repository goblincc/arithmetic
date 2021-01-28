package com.offer;

/**
 *  删除链表倒数第K个节点
 */
public class FindKthToTail {


    public ListNode findKthToTail(ListNode head, int k){
        if(head == null){
            return null;
        }
        ListNode node1 = head;
        //快节点先走k步， 剩下n-k个节点
        while(node1 != null && k > 0){
            node1 = node1.next;
            k--;
        }
        //节点遍历完了k仍然大于0，标识k值大于链表的长度， 返回null
        if(k > 0){
            return null;
        }
        ListNode node2 = head;
        //慢节点和快节点同时前进， 当快节点走到结尾时， 慢节点就到了n-k的位置
        while(node1 != null){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }
}
