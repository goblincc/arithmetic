package com.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表值
 *
 */
public class PrintListNode {
    public static void main(String[] args) {

    }

    /**
     * 递归调用
     * 例如1->2->3 ， 把2->3当做新的链表进行递归调用
     * @param node
     * @return
     */
    public ArrayList<Integer> printListNode(ListNode node){
        ArrayList<Integer> res = new ArrayList<>();
        while(node.next != null){
            res.addAll(printListNode(node.next));
            res.add(node.val);
        }
        return res;
    }

    /**
     * 利用栈先进后出的特点， 先将数据存入栈， 然后出栈的顺序即为逆序
     * @param node
     * @return
     */
    public ArrayList<Integer> printListNode2(ListNode node){
        Stack<Integer> stack1 = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        while(node.next != null){
            stack1.push(node.val);
            node = node.next;
        }
        while(!stack1.isEmpty()){
            res.add(stack1.pop());
        }
        return res;
    }
}
