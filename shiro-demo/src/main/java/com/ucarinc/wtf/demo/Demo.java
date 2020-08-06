package com.ucarinc.wtf.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: demo
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/6/7 14:22
 * @Version: 1.0
 */
public class Demo {
//    class Node {
//        int key;
//        int val;
//        Node prev;
//        Node next;
//    }
//
//    private int capacity;
//    private Node first;
//    private Node last;
//    private Map<Integer, Node> map;
//
//    public void put(int key, int value) {
//        Node node = map.get(key);
//
//        if (node == null) {
//            node = new Node();
//            node.key = key;
//            node.val = value;
//            if(map.size() == capacity) {
//                removeLast();
//            }
//            addToHead(node);
//            map.put(key, node);
//        } else {
//            node.val = value;
//            moveToHead(node);
//        }
//    }
//    private void addToHead(Node node) {
//        if (map.isEmpty()) {
//            first = node;
//            last = node;
//        } else {
//            node.next = first;
//            first.prev = node;
//            first = node;
//        }
//    }
//
//
//    private void removeLast() {
//        map.remove(last.key);
//        Node prevNode = last.prev;
//        if (prevNode != null) {
//            prevNode.next = null;
//            last = prevNode;
//        }
//    }
}
