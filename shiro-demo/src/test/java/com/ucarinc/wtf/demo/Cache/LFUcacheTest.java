package com.ucarinc.wtf.demo.Cache;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Cache
 * @ClassName: LFUcacheTest
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/6/10 17:52
 * @Version: 1.0
 */
public class LFUcacheTest {

    @Test
    public void get() {
        LFUcache<Integer,String> lfUcache = new LFUcache<Integer, String>();
        lfUcache.put(1,"test1");
        lfUcache.put(2,"test2");
        lfUcache.put(3,"test3");
        lfUcache.put(4,"test4");
        lfUcache.put(5,"test5");
        lfUcache.get(5);
        lfUcache.get(2);
        lfUcache.get(4);
        lfUcache.put(6,"test6");
    }

    @Test
    public void put() {
    }
}