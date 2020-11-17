package com.practice200.linklist;

/**
 *  反转链表
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        System.out.println(new ReverseList().reverseList(head).val);

    }

    /**
     * 递归算法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        //base case, 当链表只有一个节点时， 反转就是自身， 直接返回即可
        if(head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     *  迭代算法
     * @param head
     * @return
     */
    public ListNode reverList2(ListNode head){
        ListNode cur = head, pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 前m个节点反转
     */
    ListNode successor = null;
    public ListNode reverseList(ListNode head, int m){
        if(m == 1){
            //记录第m+1个节点
            successor = head.next;
            return head;
        }
        //第m个节点返回后， 需要反转前m-1个节点
        ListNode last = reverseList(head.next, m - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 区间[m, n]的节点反转
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseListBetween(ListNode head, int m, int n){
        if(m == 1){
            return reverseList(head, n);
        }
        head.next = reverseListBetween(head.next, m - 1, n - 1);
        return head;
    }

}
