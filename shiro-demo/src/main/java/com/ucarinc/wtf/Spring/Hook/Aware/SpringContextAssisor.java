package com.ucarinc.wtf.Spring.Hook.Aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: train
 * @Package: com.ucarinc.wtf.Spring.Hook.Aware
 * @ClassName: SpringContextAssisor
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: spring容器工具类
 * @Date: 2020/8/11 9:24
 * @Version: 1.0
 */
@Component
public class SpringContextAssisor implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextAssisor.applicationContext = applicationContext;
    }

    public static Object getBeanDefinition(String name){
        return applicationContext.getBean(name);
    }

}
