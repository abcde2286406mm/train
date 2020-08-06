package com.ucarinc.wtf.demo.Cache;

import com.ucarinc.wtf.train.Cache.LRUcache;
import org.junit.Test;

import java.util.List;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: LRUcacheTest
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/6/9 16:52
 * @Version: 1.0
 */
public class LRUcacheTest {

    @Test
    public void put() {

        LRUcache<String,String> lrUcache = new LRUcache<>();
        lrUcache.put("test1","test1");
        lrUcache.put("test2","test2");
        lrUcache.put("test6","test6");
        lrUcache.put("test3","test3");
        lrUcache.put("test4","test4");
        lrUcache.put("test5","test5");
        lrUcache.get("test2");

        List<String> list = lrUcache.getAll();
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


    }

    @Test
    public void get() {
    }
}