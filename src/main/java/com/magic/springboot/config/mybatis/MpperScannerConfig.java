package com.magic.springboot.config.mybatis;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Magicfeng007
 * @Description: 使用mybatis-spring整合的方式
 * @Date: Created in 2018-05-14---下午9:27
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class) //保证在MyBatisConfig实例化之后再实例化该类
public class MpperScannerConfig {
    // mapper接口的扫描器
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.magic.springboot.mapper");
        return mapperScannerConfigurer;
    }
}
