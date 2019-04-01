package cn.ice.cloud;

import cn.ice.cloud.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host:localhost}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private int port;

    @Value("${spring.redis.password:}")
    private String password;

    @Value("${spring.redis.timeout:0}")
    private int timeout;

    @Value("${spring.redis.maxTotal:100}")
    private int maxTotal = 100;

    @Value("${spring.redis.maxIdle:20}")
    private int maxIdle = 20;

    @Value("${spring.redis.maxWaitMillis:15000}")
    private long maxWaitMillis = 15000;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);

        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        if (null != password && password.length() > 0) {
            factory.setPassword(password);
        }
        factory.setTimeout(timeout);
        factory.setUsePool(true);
        factory.setPoolConfig(poolConfig);
        return factory;
    }

    protected RedisTemplate buildRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    @Bean(name = "userRedisTemplate")
    public RedisTemplate<String, UserDto> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return buildRedisTemplate(redisConnectionFactory);
    }
}
