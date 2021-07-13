package com.yuyang.easy.common.entity.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yuyang
 * @date 2020/11/17 15:12
 * @Description
 */
@ApiModel("Demo返参")
@Data
public class DemoVO {
    @ApiModelProperty("返参1")
    private String property1;
    @ApiModelProperty("返参2")
    private String property2;
}
