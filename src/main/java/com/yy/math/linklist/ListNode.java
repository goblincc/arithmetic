package com.yy.math.linklist;

/**
 * Created by Administrator on 2020/6/11.
 */
public class ListNode {
    private Node root;

    public void addNode(int value){
        Node node = new Node(value);
        if(root == null){
            root = node;
        }else{
            node.next = root;
            root = node;
        }
    }

    public void show(){
        Node current = root;
        while(current!=null){
            current.show();
            current = current.next;
        }
    }
}
