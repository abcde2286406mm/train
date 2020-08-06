package com.ucarinc.wtf.demo.Cache;

import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Cache
 * @ClassName: LFUcache
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 最近最少使用算法
 * @Date: 2020/6/10 17:28
 * @Version: 1.0
 */
public class LFUcache<K,V> {
    HashMap<K,Node> table;
    static int defaultSize = 5;

    class Node{
        K key;
        V val;
        int count;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }
    public V get(K key){
        if (key == null || table.get(key) == null){
            return null;
        }
        Node node = table.get(key);
        node.count++;
        table.put(key,node);
        return node.val;
    }
    public void put(K key,V val){
        if (key == null){
            return;
        }
        if (table == null || table.size() == 0){
            table = new HashMap<>();
        }
        if (table.get(key) == null){
            if (table.size() == defaultSize){
                removeLeastUsed();
            }
            Node node = new Node(key,val);
            table.put(key,node);
        }
    }
    private void removeLeastUsed(){
        Set<Map.Entry<K, Node>> entries = table.entrySet();
        K lkey = null;
        int lcount = Integer.MAX_VALUE;
        for (Map.Entry<K, Node> map : entries){
            if (map.getValue().count < lcount){
                lcount = map.getValue().count;
                lkey = map.getValue().key;
            }
        }
        table.remove(lkey);
    }
}
