package com.enough.checker;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: check-spring-boot-starter
 * @description: 参数校验自动配置类
 * @author: lidong
 * @create: 2020/01/16
 */
@Configuration
@ConditionalOnWebApplication
//@EnableConfigurationProperties({CheckProperties.class})//指明配置类，这样 CheckProperties 才能被注入
@EnableConfigurationProperties//指明配置类，这样 CheckProperties 才能被注入
public class CheckAutoConfiguration {
    @Bean
    public CheckParameterAspect checkParameterAspect(){
        return new CheckParameterAspect();
    }
}
