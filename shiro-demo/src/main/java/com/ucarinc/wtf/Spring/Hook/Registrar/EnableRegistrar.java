package com.ucarinc.wtf.Spring.Hook.Registrar;

import org.reflections.Reflections;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: train
 * @Package: com.ucarinc.wtf.Spring.Hook.Registrar
 * @ClassName: EnableRegistrar
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/8/11 11:28
 * @Version: 1.0
 */
public class EnableRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Reflections reflections = new Reflections("com.ucarinc.wtf");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(EnableThrowable.class);
        for (Class clazz: typesAnnotatedWith){
            BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(clazz).getBeanDefinition();
            registry.registerBeanDefinition(beanDefinition.getBeanClassName(),beanDefinition);
        }
    }
}
