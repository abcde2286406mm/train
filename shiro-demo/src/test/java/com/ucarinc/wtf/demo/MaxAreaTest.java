package com.ucarinc.wtf.demo;

import org.junit.Test;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: MaxAreaTest
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/13 11:40
 * @Version: 1.0
 */
public class MaxAreaTest {

    @Test
    public void maxArea() {
        int[] ints = {1,3,5,4,6,2};
        System.out.println(MaxArea.maxArea(ints));
    }
}