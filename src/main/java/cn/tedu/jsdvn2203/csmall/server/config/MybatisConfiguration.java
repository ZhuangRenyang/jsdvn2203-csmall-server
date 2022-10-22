package cn.tedu.jsdvn2203.csmall.server.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
@Slf4j
@MapperScan("cn.tedu.jsdvn2203.csmall.server.mapper")
@Configuration
public class MybatisConfiguration {
    public MybatisConfiguration() {
        log.info("加载装配类,MybatisConfiguration");
    }
}
