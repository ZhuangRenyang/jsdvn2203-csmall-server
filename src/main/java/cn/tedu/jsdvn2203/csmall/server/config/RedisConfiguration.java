package cn.tedu.jsdvn2203.csmall.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Serializable>redisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ){
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();

        //连接Redis
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        //序列化器- 对象序列化才能在网络传输
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.json());
        return redisTemplate;
    }
}
