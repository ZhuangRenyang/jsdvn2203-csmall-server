package cn.tedu.jsdvn2203.csmall.server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
@MapperScan("cn.tedu.jsdvn2203.csmall.server.mapper")
@Configuration
public class MybatisConfiguration {
    public MybatisConfiguration() {
       System.out.println("加载装配类,MybatisConfiguration");
    }
}
