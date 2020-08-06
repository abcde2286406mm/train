package com.ucarinc.wtf.train.Cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: LRUcache
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/6/9 15:58
 * @Version: 1.0
 */
public class LRUcache<K,V> {
    HashMap<K,Node> table;
    Node<K,V> first,tail;
    static int defaultSize = 5;
    class Node<K,V>{
        Node pre;
        Node next;
        K key;
        V val;
        Node(K key,V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key,V val){
        if (key == null){
            return;
        }
        if (table == null || table.size() == 0){
            table = new HashMap<>();
        }
        Node node = new Node(key,val);
        if (table.get(key) == null){
            if (table.size() == defaultSize){
                remove(first.key);
            }
            addToTail(key,node);
        }else {
            remove(key);
            addToTail(key,node);
        }
    }
    public V get(K key){
        if (table.get(key) == null){
            return null;
        }else {
            Node node = table.get(key);
            remove(key);
            addToTail(key,node);
            return (V) node.val;
        }
    }
    private void remove(K key){
        Node oldNode = table.get(key);
        if (first.equals(oldNode)){
            first = first.next;
            oldNode.next = null;
        }else if (tail.equals(oldNode)){
            return;
        }else {
            oldNode.pre.next = oldNode.next;
            oldNode.next.pre = oldNode.pre;
            oldNode.pre = null;
            oldNode.next = null;
        }
        table.remove(key);
    }
    private void addToTail(K key,Node node){
        if (first == null && tail == null){
            first = node;
            tail = node;
        }else {
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        table.put(key,node);
    }
    public List<V> getAll(){
        if (first == null){
            return null;
        }
        Node node = first;
        List<V> list = new ArrayList<>();
        do {
            list.add((V) node.val);
            node = node.next;
        }while (node != null);
        return list;
    }
}
