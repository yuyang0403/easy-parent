package com.yuyang.easy.common.entity.demo.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yuyang
 * @date 2020/11/17 15:11
 * @Description Demo入参
 */
@ApiModel("演示Demo入参")
@Data
public class DemoCondition {
    @ApiModelProperty("demo-name")
    private String name;
    @ApiModelProperty("demo-content")
    private String content;
}
