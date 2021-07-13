package com.yuyang.easy.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yuyang
 * @date 2020/5/9 15:55
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EasyGatewayApplication {
    private static final Logger log = LoggerFactory.getLogger(EasyGatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EasyGatewayApplication.class, args);
        log.info("网关服务-启动成功........");
    }
}