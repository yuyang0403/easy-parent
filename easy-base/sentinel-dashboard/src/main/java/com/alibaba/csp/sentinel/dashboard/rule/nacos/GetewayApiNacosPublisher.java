package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.controller.gateway.GatewayFlowRuleController;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * @author yuyang
 * @date 2020/11/10 20:03
 * @Description gateway 推送 api
 */
@Component("getewayApiNacosPublisher")
public class GetewayApiNacosPublisher implements DynamicRulePublisher<List<ApiDefinitionEntity>> {

    private final Logger logger = LoggerFactory.getLogger(GetewayApiNacosPublisher.class);
    @Autowired
    private ConfigService configService;
    @Autowired
    private Converter<List<ApiDefinitionEntity>, String> converter;
    public static final String GATEWAY_DATA_ID_POSTFIX = "-sentinel-gateway-api";
    public static final String GROUP_ID = "default";

    @Override
    public void publish(String app, List<ApiDefinitionEntity> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        configService.publishConfig(app+ GATEWAY_DATA_ID_POSTFIX,
                GROUP_ID,converter.convert(rules));
        logger.info("向nacos推送api完成");
    }
}