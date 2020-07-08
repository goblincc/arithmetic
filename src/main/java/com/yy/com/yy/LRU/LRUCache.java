package com.yy.com.yy.LRU;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Administrator on 2020/6/19.
 */

/**
 * LinkedList储存key值，实现最近最少使用。
 get：
 如果存在该key，则先把LinkedList中原来的key值删除，再把key添加到LinkedList末尾，越最近使用的key越靠近LinkedList末尾。
 put：
 如果存在该key，也要像get一样，先把LinkedList中原来的key值删除，再把key添加到LinkedList末尾，直接调用HashMap的put方法，新的value值就会覆盖旧的value值。
 如果put之前元素个数已经达到了容量，则把LinkedList中第一个元素删除，越是最近最少使用的key越靠近LinkedList头部。然后调用HashMap的put方法。
 不存在该key，也没有到达容量，直接调用HashMap的put方法。
 */
public class LRUCache {
    HashMap<Integer, Integer> map;
    LinkedList<Integer> list;
    int cap;

    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public int get(int key){
        if(map.containsKey(key)){
            //当需要获取的值存在时，删除链表中的key，同时把这个key加到链表的后面
            list.remove((Integer)key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value){
        //当插入的值存在时，删除链表中的key，同时把这个key加到链表的后面， 并更新map中的值
        if(map.containsKey(key)){
            list.remove((Integer)key);
            list.addLast(key);
            map.put(key, value);
        }else{
            //当插入的值不存在，但是容量已满时，删除链表中的第一个元素，把key加入到链表末尾，并删除map中的值
            if(list.size() == cap){
                Integer headValue = list.removeFirst();
                map.remove(headValue);
                map.put(key, value);
                list.addLast(key);
            }else{
                //当插入的值不存在，容量没满时，直接把key添加到链表末尾，更新map中的值
                list.addLast(key);
                map.put(key, value);
            }
        }
    }
}
