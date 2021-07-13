package com.yuyang.easy.web.controller;

import com.yuyang.easy.common.entity.demo.condition.DemoCondition;
import com.yuyang.easy.common.entity.demo.vo.DemoVO;
import com.yuyang.easy.web.service.DemoBusinessService;
import com.yuyang.easy.common.entity.customer.model.TestModel;
import com.yuyang.easy.common.util.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author yuyang
 * @date 2020/5/12 19:38
 * @Description
 */
@Api(tags = "Demo服务")
@RestController
@RequestMapping("demo")
public class DemoBusinessController {

    @Autowired
    DemoBusinessService demoBusinessService;

    @RequestMapping(method = RequestMethod.POST,value = "demoMethod")
    @ApiOperation(value = "DEMO请求",notes = "DEMO请求",response = DemoVO.class)
    public ResponseResult<DemoVO> demo(@RequestBody DemoCondition demoCondition) {

        return new ResponseResult<>(demoBusinessService.demoService(demoCondition));
    }

}
