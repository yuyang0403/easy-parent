package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.controller.gateway.GatewayFlowRuleController;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author yuyang
 * @date 2020/11/10 20:08
 * @Description gateway限流规则推送
 */
@Component("gatewayFlowRulesNacosPublisher")
public class GatewayFlowRulesNacosPublisher implements DynamicRulePublisher<List<GatewayFlowRuleEntity>> {

    private final Logger logger = LoggerFactory.getLogger(GatewayFlowRulesNacosPublisher.class);

    @Autowired
    private ConfigService configService;
    @Autowired
    private Converter<List<GatewayFlowRuleEntity>, String> converter;
    public static final String GATEWAY_DATA_ID_POSTFIX = "-sentinel-gateway-flow";
    public static final String GROUP_ID = "default";

    @Override
    public void publish(String app, List<GatewayFlowRuleEntity> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        configService.publishConfig(app + GATEWAY_DATA_ID_POSTFIX,
                GROUP_ID, converter.convert(rules));
        logger.info("向nacos推送限流规则完成");
    }
}