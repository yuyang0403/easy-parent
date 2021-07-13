package com.yuyang.easy.web.service;

import com.yuyang.easy.common.entity.customer.model.TestModel;
import com.yuyang.easy.common.entity.demo.condition.DemoCondition;
import com.yuyang.easy.common.entity.demo.vo.DemoVO;

/**
 * @author yuyang
 * @date 2020/5/11 9:56
 * @Description
 */
public interface DemoBusinessService {
    /**
     * demo service
     * @param condition
     * @return
     */
    DemoVO demoService(DemoCondition condition);
}
