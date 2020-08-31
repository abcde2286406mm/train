package com.ucarinc.wtf;


import com.ucarinc.wtf.Spring.Hook.Registrar.EnableRegistrar;
import com.ucarinc.wtf.Spring.Hook.Registrar.EnableThrowableBean;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 文件说明
 * @author 作者 （邮箱）y
 * @date yyyy-MM-dd HH:mm:ss
 * @version 1.0
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ucarinc.wtf.dao")
@Import(value = {EnableRegistrar.class})
public class ShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }
}
