package com.ucarinc.wtf.train.Reflect;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Reflect
 * @ClassName: ReflectDemo
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/7/22 15:37
 * @Version: 1.0
 */
public class ReflectDemo {
    String str;
    public ReflectDemo(){
    }
    private void output(){
        System.out.println("1");
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, FileNotFoundException {
        ThreadLocal threadLocal = new ThreadLocal();
        ReflectDemo reflectDemo = new ReflectDemo();
        Class reflectDemoClass = ReflectDemo.class;
        Method method = reflectDemoClass.getDeclaredMethod("output");
        method.invoke(reflectDemo);
        Class reflectDemoClass2 = Class.forName("com.ucarinc.wtf.train.Reflect.ReflectDemo");
        Class<? extends ReflectDemo> reflectDemoClass3 = reflectDemo.getClass();

    }
}
