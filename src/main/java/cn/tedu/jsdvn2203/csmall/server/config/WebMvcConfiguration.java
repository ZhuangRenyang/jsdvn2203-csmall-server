package cn.tedu.jsdvn2203.csmall.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")    //配置被跨域路径(具体地址)
                .allowedOriginPatterns("*")      //项目的所有接口支持跨域
                .allowedHeaders("*")             //属性表示允许的请求头有哪些
                .allowedMethods("*")             //请求方式:post/get/put/
                .allowCredentials(true)          //是否允许
                .maxAge(3600);
    }
}
