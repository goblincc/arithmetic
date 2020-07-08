package com.yy.math.linklist;

/**
 * Created by Administrator on 2020/6/11.
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public void show(){
        System.out.println(this.value);
    }
}
