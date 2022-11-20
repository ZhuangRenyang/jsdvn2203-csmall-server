package cn.tedu.jsdvn2203.csmall.server.config;

import cn.tedu.jsdvn2203.csmall.server.filter.JwtAuthorizationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启全局的授权访问检查
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;


    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    public BCryptPasswordEncoder passwordEncoder() {
        log.debug("创建密码编码器组件：BCryptPasswordEncoder");
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //"白名单" - 无需登录即可访问
        // 在配置路径时，星号是通配符
        // 1个星号只能匹配任何文件夹或文件的名称，但不能跨多个层级
        // 例如：/*/test.js，可以匹配到 /a/test.js 和 /b/test.js，但不可以匹配到 /a/b/test.js
        // 2个连续的星号可以匹配若干个文件夹的层级
        // 例如：/**/test.js，可以匹配 /a/test.js 和 /b/test.js 和 /a/b/test.js
        String[] urls = {"/admins/login",
                "/doc.html",
                "/**/*.css",
                "/**/*.js",
                "/swagger-resources",
                "/v2/api-docs"
        };
        http.cors();
        http.csrf().disable(); //禁用跨域访问

        // /*  - 匹配1层级路径，例如"/admins","/brands"..
        // /** - 匹配若干层级路径
        http.authorizeRequests()//请求需要被授权才可以访问
                .antMatchers(urls) //匹配某些路径
                .permitAll()//允许直接访问(不需要经过认证授权)
                .anyRequest() //除了以上配置的任何其他请求
                .authenticated(); //已经通过认证才能访问

        //添加处理jwt的过滤器，必须执行在处理用户名密码过滤器(Security内置)之前。
        http.addFilterBefore(jwtAuthorizationFilter,
                UsernamePasswordAuthenticationFilter.class);
    }
}
