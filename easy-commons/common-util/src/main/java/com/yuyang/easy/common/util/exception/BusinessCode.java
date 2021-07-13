package com.yuyang.easy.common.util.exception;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuyang
 */
public final class BusinessCode {

    @ApiModelProperty("成功")
    public static final int CODE_OK = 0;
    @ApiModelProperty("请求超时")
    public static final int CODE_998=998;
    @ApiModelProperty("请求被拒绝")
    public static final int CODE_999=999;
    @ApiModelProperty("通用：自定义异常信息,通过占位符赋值！")
    public static final int CODE_1000=1000;
    @ApiModelProperty("业务繁忙")
    public static final int CODE_1001 = 1001;
    @ApiModelProperty("登录凭证无效")
    public static final int CODE_1002 = 1002;
    @ApiModelProperty("没有权限")
    public static final int CODE_1003 = 1003;
    @ApiModelProperty("账号无效")
    public static final int CODE_1004 = 1004;
    @ApiModelProperty("密码错误")
    public static final int CODE_1005 = 1005;
    @ApiModelProperty("账号未启用")
    public static final int CODE_1006 = 1006;
    @ApiModelProperty("参数无效")
    public static final int CODE_1007 = 1007;





}
