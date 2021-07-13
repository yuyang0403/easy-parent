package com.yuyang.easy.interfaces.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuyang
 * @date 2020/11/13 19:49
 * @Description Redisson初始化
 */
@Configuration
public class RedissonConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedissonConfig.class);

    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public Redisson redisson(){
        String[] nodes = clusterNodes.split(",");
        for(int i=0;i<nodes.length;i++){
            nodes[i] = "redis://"+nodes[i];
        }
        Config config = new Config();
        config.useClusterServers().setPassword(password).addNodeAddress(nodes);
        return (Redisson) Redisson.create(config);
    }
}
