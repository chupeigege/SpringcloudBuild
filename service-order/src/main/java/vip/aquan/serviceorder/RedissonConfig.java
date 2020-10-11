package vip.aquan.serviceorder;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wcp
 * @date: 2020/10/11 22:08
 * @Description: redisson配置类
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient getRedisClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }

}
