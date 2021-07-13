package com.yuyang.easy.common.entity.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @author yuyang
 * @date 2020/11/20 19:19
 * @Description
 */
@ApiModel("分页参数")
@Data
public class PageCondition {
    @ApiModelProperty("每页条数")
    private Integer pageSize;
    @ApiModelProperty("页码")
    private Integer pageNum;
}
