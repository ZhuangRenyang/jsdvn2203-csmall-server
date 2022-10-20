package cn.tedu.jsdvn2203.csmall.server.config;

import cn.tedu.jsdvn2203.csmall.server.controller.CategoryController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;
import java.util.Date;

@Configuration
public class BeanConfig {

    @Lazy
    @Bean
    public Date date(){
        System.out.println("BeanConfig.date()");
//        Date date = new Date();
//        System.out.println("当前系统时间"+date);
        return new Date();
    }

    @Bean
    public LocalDateTime localDateTime(){
        System.out.println("BeanConfig.localDateTime()");
        return LocalDateTime.now();
    }


}
