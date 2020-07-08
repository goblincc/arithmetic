package com.yy.math.com.yy.treeAndList;

/**
 * Created by Administrator on 2020/6/19.
 */
public class TreeToDoublyList {
    public Node pre;
    public Node head;
    public Node treeToDoublyList(Node root){
        if(root == null) return null;
        dfs(root);
        //进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
        pre.right = head;
        head.left = pre;
        return head;
    }

    public void dfs(Node cur){
        if(cur == null) return;
        dfs(cur.left);
        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        //pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作
        if(pre != null){
            pre.right = cur;
        }else{
            head = cur;
        }
        //pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。
        cur.left = pre;
        //pre指向当前的cur
        pre = cur;
        //全部迭代完成后，pre指向双向链表中的尾节点
        dfs(cur.right);
    }
}
