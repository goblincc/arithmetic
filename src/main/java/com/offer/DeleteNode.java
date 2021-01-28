package com.offer;

public class DeleteNode {
    public static void main(String[] args) {

    }

    /**
     * 删除链表节点
     * @param head
     * @param tobeDelete
     * @return
     */
    public ListNode delete(ListNode head, ListNode tobeDelete){
        if(head == null){
            return null;
        }
        //如果目标节点不是尾结点，可以将目标节点的下个节点的值赋给目标节点， 目标节点连接下个节点的下个节点
        if(tobeDelete.next != null){
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        }else{
            //如果目标节点是头结点， 头结点赋值为null
            if(head == tobeDelete){
                head = null;
            }else{
                //如果目标节点是尾结点， 遍历链表找到目标节点的上一个节点， 让该节点的下个节点为null即可
                ListNode cur = head;
                while(cur.next != tobeDelete){
                    cur = cur.next;
                }
                cur.next = null;

            }
        }
        return head;
    }
}
