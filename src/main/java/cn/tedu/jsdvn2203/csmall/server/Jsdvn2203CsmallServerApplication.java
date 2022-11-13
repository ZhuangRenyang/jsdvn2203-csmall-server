package cn.tedu.jsdvn2203.csmall.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class Jsdvn2203CsmallServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Jsdvn2203CsmallServerApplication.class, args);
    }

}
