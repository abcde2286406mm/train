package com.ucarinc.wtf.Spring;

import com.ucarinc.wtf.Spring.Hook.Aware.SpringContextAssisor;

import java.util.Hashtable;

/**
 * @ProjectName: train
 * @Package: com.ucarinc.wtf.Spring
 * @ClassName: Test
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/8/11 9:38
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        SpringContextAssisor.getBeanDefinition("ShiroApplication");
    }
}
    