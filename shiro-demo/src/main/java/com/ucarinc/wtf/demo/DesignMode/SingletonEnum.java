package com.ucarinc.wtf.demo.DesignMode;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: SingletonEnum
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/4/1 13:30
 * @Version: 1.0
 */
public enum SingletonEnum {

    //当只有一个枚举值时，可视为单例模式
    INSTANCE(1,"wtf");

    private Integer age;
    private String name;

    //枚举中的构造函数默认是private的
    SingletonEnum(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
    public void doSomething() {
        System.out.println("doSomething");
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
