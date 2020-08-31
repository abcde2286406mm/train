package com.ucarinc.wtf.Spring.Hook.Processor;

import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: train
 * @Package: com.ucarinc.wtf.Spring.Hook.Processor
 * @ClassName: EnableThrowableBeanProcessor
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/8/11 15:18
 * @Version: 1.0
 */
@Component
public class EnableThrowableBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        if (beanName.contains("EnableThrowableBean")){
            System.out.println(beanName+" Before Initialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
        if (beanName.contains("EnableThrowableBean")){
            System.out.println(beanName+" After Initialization");
        }
        return bean;
    }
}
