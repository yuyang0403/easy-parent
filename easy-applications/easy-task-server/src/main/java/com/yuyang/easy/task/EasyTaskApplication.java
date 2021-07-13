package com.yuyang.easy.task;

import com.yuyang.easy.common.util.config.ServerConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author yuyang
 * @date 2020/5/9 15:55
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@Import({ServerConfiguration.class})
@ComponentScan(basePackages = "com.yuyang.easy")
@EnableFeignClients(basePackages = "com.yuyang.easy.common.feign")
@MapperScan("com.yuyang.easy.common.mapper")
@EnableAsync
public class EasyTaskApplication {
    private static final Logger log = LoggerFactory.getLogger(EasyTaskApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EasyTaskApplication.class, args);
        log.info("定时服务-启动成功........");
    }

}
