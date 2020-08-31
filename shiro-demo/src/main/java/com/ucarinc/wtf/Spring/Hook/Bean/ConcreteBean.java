package com.ucarinc.wtf.Spring.Hook.Bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ProjectName: train
 * @Package: com.ucarinc.wtf.Spring.Hook.Bean
 * @ClassName: ConcreteBean
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 实例化bean前后的钩子
 * @Date: 2020/8/11 10:08
 * @Version: 1.0
 */
@Component
public class ConcreteBean implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("释放");
    }

    /***
     * @author tengfei.wu01@ucarinc.com
     * @description  设置完所有bean属性之后调用的钩子函数
     * @date 2020/8/11 10:09
     * @param
     * @return void
    */
    @Override
    public void afterPropertiesSet() throws Exception {

        StackTraceElement stack[] = Thread.currentThread().getStackTrace();
        System.out.println("初始化资源完毕");
    }
}
