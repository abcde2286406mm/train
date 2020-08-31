package com.ucarinc.wtf.Spring.Hook.Registrar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @ProjectName: train
 * @Package: com.ucarinc.wtf.Spring.Hook.Registrar
 * @ClassName: EnableThrowable
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/8/11 14:42
 * @Version: 1.0
 */
@Target(ElementType.TYPE)
public @interface EnableThrowable {
    public String name() default "";
}
