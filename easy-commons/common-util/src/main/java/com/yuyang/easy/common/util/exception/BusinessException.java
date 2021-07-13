package com.yuyang.easy.common.util.exception;

import io.swagger.annotations.ApiModelProperty;

/**
 * 统一的业务异常类
 * @author yuyang
 */
public class BusinessException extends RuntimeException {
	@ApiModelProperty("错误码，参考BusinessCode")
	protected int errorCode;
	@ApiModelProperty("错误信息，抛出异常不需要放入信息")
	protected String message;
	// 验证码还有%s秒过期

	@ApiModelProperty("占位符内容,目前支持字符串%s")
	protected String[] placeHolder;

	public BusinessException() {
		super();
	}

	public BusinessException(int errorCode) {
		this();
		this.errorCode = errorCode;
	}

	/**
	 * 如果有动态错误信息请使用该Constructor
	 * 注：code.properties请使用%s作为占位符，支持多个，按照顺序
	 * @param errorCode
	 * @param placeHolder
	 */
	public BusinessException(int errorCode,String ...placeHolder){
		this();
		this.errorCode=errorCode;
		this.placeHolder=placeHolder;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String[] placeHolder) {
		this.placeHolder = placeHolder;
	}
}
