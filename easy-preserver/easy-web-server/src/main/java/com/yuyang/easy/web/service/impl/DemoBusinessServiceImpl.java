package com.yuyang.easy.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.yuyang.easy.common.entity.demo.condition.DemoCondition;
import com.yuyang.easy.common.entity.demo.vo.DemoVO;
import com.yuyang.easy.common.feign.customer.CustomerBusinessFeign;
import com.yuyang.easy.web.service.DemoBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2020/5/11 9:57
 * @Description
 */
@Service
public class DemoBusinessServiceImpl implements DemoBusinessService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoBusinessServiceImpl.class);
    /**
     * feign调用
     */
    @Resource
    CustomerBusinessFeign customerBusinessFeign;

    /**
     * demo service
     * @param condition
     * @return
     */
    @Override
    public DemoVO demoService(DemoCondition condition) {
        LOGGER.info("demoService,参数：{}", JSON.toJSONString(condition));
        LOGGER.info("demoService,业务处理，调用feign");
        //feign调用的两种方式，适用于不同的场景
        //如果抛异常了，说明feign响应有问题
        //customerBusinessFeign.demoFeign(condition).getDataWithException();
        //忽略feign的异常，直接获取返回的数据，有异常则为空
        DemoVO demoVO = customerBusinessFeign.demoFeign(condition).getData();
        //DemoVO demoVO=customerBusinessFeign.demoFeign(condition).getData();
        LOGGER.info("demoService,业务处理，调用feign完毕,返参：{}",JSON.toJSONString(demoVO));
        return demoVO;
    }
}
