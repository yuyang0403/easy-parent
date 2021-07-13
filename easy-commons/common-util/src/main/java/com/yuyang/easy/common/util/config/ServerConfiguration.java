package com.yuyang.easy.common.util.config;

import com.yuyang.easy.common.util.exception.MessageHelper;
import com.yuyang.easy.common.util.exception.ServiceHandlerExceptionResolver;
import org.springframework.context.annotation.Bean;

/**
 * @author yuyang
 * @date 2020/5/11 9:52
 * @Description
 */

public class ServerConfiguration {

    /**
     * 统一异常处理
     */
    @Bean
    public ServiceHandlerExceptionResolver serviceHandlerExceptionResolver() {
        return new ServiceHandlerExceptionResolver();
    }

    @Bean
    public MessageHelper messageHelper() {
        return new MessageHelper();
    }
}
