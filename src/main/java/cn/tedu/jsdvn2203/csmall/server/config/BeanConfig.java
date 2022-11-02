package cn.tedu.jsdvn2203.csmall.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Configuration
public class BeanConfig {

    @Lazy
    @Bean
    public static Date date(){
        log.info("BeanConfig.date()");
//        Date date = new Date();
//        log.info("当前系统时间:{}",date);
        return new Date();
    }

    @Bean
    public static LocalDateTime localDateTime(){
        log.info("BeanConfig.localDateTime()");
        return LocalDateTime.now();
    }

}
