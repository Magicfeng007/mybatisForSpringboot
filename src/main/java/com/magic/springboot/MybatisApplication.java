package com.magic.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

/**
 * @Author: Magicfeng007
 * @Description: 使用mybatis-spring整合的方式
 * @Date: Created in 2018-05-14---下午9:20
 */
@Controller
@PropertySource(value = {"classpath:jdbc.properties"})
@Configuration
@ComponentScan(basePackages = "com.magic.springboot")
@SpringBootApplication
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class,args);
    }
}
