package com.wsm;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableDubbo            //启动Doubbo
public class MyOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(com.wsm.MyOrderApp.class,args);
    }
}
