package com.huanhai.bootmain.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ListPosition;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Configuration
@PropertySource(value = "classpath:redis.properties")
public class RedisConfig {
    @Value("${redis.ip}")
    public String ip;
    @Value("${redis.port}")
    public String port;
    @Value("${redis.password}")
    public String password;
    @Value("${redis.pool.maxTotal}")
    public String maxTotal;
    @Value("${redis.pool.maxIdle}")
    public String maxIdle;
    @Value("${redis.pool.maxWaitMillis}")
    public String maxWaitMillis;
    @Value("${redis.pool.testOnBorrow}")
    public String testOnBorrow;

    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.valueOf(maxTotal));
        jedisPoolConfig.setMaxIdle(Integer.valueOf(maxIdle));
        jedisPoolConfig.setMaxWaitMillis(Long.valueOf(maxWaitMillis));
        jedisPoolConfig.setTestOnBorrow(Boolean.valueOf(testOnBorrow));
        return new JedisPool(jedisPoolConfig, ip, Integer.valueOf(port), 10000);
    }
}
