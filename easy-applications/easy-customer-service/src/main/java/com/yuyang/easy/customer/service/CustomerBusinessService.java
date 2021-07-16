package com.yuyang.easy.customer.service;

import com.yuyang.easy.common.entity.common.PagedVO;
import com.yuyang.easy.common.entity.customer.condition.DemoSearchCondition;
import com.yuyang.easy.common.entity.customer.model.TestModel;

import java.util.List;

/**
 * @author yuyang
 * @date 2020/5/11 9:56
 * @Description
 */
public interface CustomerBusinessService {
    void test();
    Integer saveTest(TestModel testModel);
    void testRedission();

    /**
     * 演示分页查询
     * @param condition
     * @return
     */
    PagedVO<TestModel> demoPage(DemoSearchCondition condition);
}
