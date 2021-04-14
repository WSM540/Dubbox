package com.wsm;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDubbo
@EnableHystrix          //熔断降级Hystrix 启动注解！
public class MyUserApp {
    public static void main(String[] args) {
        SpringApplication.run(com.wsm.MyUserApp.class, args);
    }
}
