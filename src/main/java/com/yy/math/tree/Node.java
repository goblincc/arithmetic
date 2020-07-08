package com.yy.math.tree;

import java.util.List;

/**
 * Created by Administrator on 2020/6/15.
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node(){

    }

    public Node(int val){
        this.val = val;
    }

    public Node(int val, List<Node> children){
        this.val = val;
        this.children = children;
    }
}
