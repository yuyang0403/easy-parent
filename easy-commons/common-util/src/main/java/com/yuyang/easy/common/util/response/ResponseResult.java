package com.yuyang.easy.common.util.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yuyang.easy.common.util.exception.BusinessException;
import com.yuyang.easy.common.util.exception.MessageHelper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yuyang
 */
@ApiModel("接口返回标准数据")
public class ResponseResult<T> {
    @ApiModelProperty("0-通过data获取数据, 其他-通过message输出错误")
    private int code = 0;
    @ApiModelProperty("当code不为0时, 表示错误信息")
    private String message;
    @ApiModelProperty("当code为0时, 可获取响应结果")
    private T data;

    public ResponseResult() {

    }

    public ResponseResult(int code) {
        this.code = code;
        if (code != 0) {
            this.message = MessageHelper.getInstance().getMessage(String.valueOf(code), "ERROR:" + code);
        }
    }

    public ResponseResult(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseResult suc(T t){
         ResponseResult result=new ResponseResult();
         result.setCode(0);
         result.setData(t);
        return result;
    }

    /**
     * feign服务之间调用获取返回数据推荐该方法，可以抛出异常
     * @return
     */
    @JsonIgnore
    public T getDataWithException() {
        if(code != 0 && code != 200){
            BusinessException businessException=new BusinessException(code);
            businessException.setMessage(this.message);
            throw businessException;
        }
        return data;
    }
}
