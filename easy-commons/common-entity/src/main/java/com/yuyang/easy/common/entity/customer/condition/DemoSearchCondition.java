package com.yuyang.easy.common.entity.customer.condition;

import com.yuyang.easy.common.entity.common.PageCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @author yuyang
 * @date 2020/11/20 19:19
 * @Description
 */
@ApiModel("演示分页查询入参")
@Data
public class DemoSearchCondition extends PageCondition {
    @ApiModelProperty("演示参数")
    private String condition;
}
