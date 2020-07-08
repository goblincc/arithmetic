package com.yy.math.com.yy.treeAndList;

/**
 * Created by Administrator on 2020/6/19.
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(){}

    public Node(int val){
        this.val = val;
    }

    public Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
