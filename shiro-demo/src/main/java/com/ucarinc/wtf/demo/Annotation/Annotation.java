package com.ucarinc.wtf.demo.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: Annotation
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/7 10:16
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Annotation {
    Class<? extends Exception>[] value();
}
