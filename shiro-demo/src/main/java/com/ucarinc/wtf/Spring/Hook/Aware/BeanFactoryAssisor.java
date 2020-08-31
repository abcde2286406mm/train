package com.ucarinc.wtf.Spring.Hook.Aware;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: train
 * @Package: com.ucarinc.wtf.Spring.Hook.Aware
 * @ClassName: BeanFactoryAssisor
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/8/11 10:03
 * @Version: 1.0
 */
@Component
public class BeanFactoryAssisor implements BeanFactoryAware {
    private static BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanFactoryAssisor.beanFactory = beanFactory;
    }
    public static Object get(String name){
        return beanFactory.getBean(name);
    }
}
