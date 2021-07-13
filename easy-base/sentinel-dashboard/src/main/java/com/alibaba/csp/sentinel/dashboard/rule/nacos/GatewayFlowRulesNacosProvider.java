package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.controller.gateway.GatewayFlowRuleController;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
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
 * @date 2020/11/10 20:06
 * @Description gateway 限流规则拉取
 */
@Component("gatewayFlowRulesNacosProvider")
public class GatewayFlowRulesNacosProvider implements DynamicRuleProvider<List<GatewayFlowRuleEntity>> {

    private final Logger logger = LoggerFactory.getLogger(GatewayFlowRulesNacosProvider.class);

    @Autowired
    private ConfigService configService;
    @Autowired
    private Converter<String, List<GatewayFlowRuleEntity>> converter;
    public static final String GATEWAY_DATA_ID_POSTFIX = "-sentinel-gateway-flow";
    public static final String GROUP_ID = "default";
    @Override
    public List<GatewayFlowRuleEntity> getRules(String appName) throws Exception {
        String rules = configService.getConfig(appName +GATEWAY_DATA_ID_POSTFIX,
                GROUP_ID, 3000);
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        logger.info("获取nacos中的限流规则完成");
        return converter.convert(rules);
    }

}