package com.yuyang.easy.common.util.exception;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务端异常统一处理错误码
 * @author yuyang
 */
public class ServiceHandlerExceptionResolver implements HandlerExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(ServiceHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        int code;
        String message;
        BusinessException businessException = findBusinessException(ex);
        if (businessException != null) {
            code = businessException.getErrorCode();
            message = businessException.getMessage();
            if (StringUtils.isBlank(message)) {
                message = MessageHelper.getInstance().getMessage(String.valueOf(code), StringUtils.EMPTY);
            }

            log.warn(getBusinessExceptionInfo(message, businessException));
        }else {
            log.error("未知异常,message=" + ex.getMessage(), ex);
            code = BusinessCode.CODE_1001;
            message = MessageHelper.getInstance().getMessage(String.valueOf(BusinessCode.CODE_1001));
        }
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.addStaticAttribute("code", code);
        view.addStaticAttribute("message", messagePlaceHolder(message,businessException));
        return new ModelAndView(view);
    }

    /**
     * 给消息处理占位符
     * @param message
     * @param ex
     * @return
     */
    private String messagePlaceHolder(String message,BusinessException ex){
        if(ex==null){
            return message;
        }
        String [] placeHolder=ex.getPlaceHolder();
        if(placeHolder!=null&&placeHolder.length>0){
            message=String.format(message,placeHolder);
        }
        return message;
    }

    private BusinessException findBusinessException(Throwable ex) {
        if (ex == null) {
            return null;
        }
        if (ex instanceof BusinessException) {
            return (BusinessException) ex;
        }
        return findBusinessException(ex.getCause());
    }

    private String getBusinessExceptionInfo(String message, BusinessException e) {
        StringBuilder str = new StringBuilder(200);
        str.append("业务异常")
                .append(":")
                .append(e.getErrorCode())
                .append(":")
                .append(messagePlaceHolder(message,e))
                .append(StringUtils.SPACE).append(e.getMessage());
        if (ArrayUtils.isNotEmpty(e.getStackTrace())) {
            StackTraceElement trace = e.getStackTrace()[0];
            str.append(StringUtils.SPACE).append(trace.getClassName())
                    .append("#").append(trace.getMethodName())
                    .append(":").append(trace.getLineNumber());
        }
        return str.toString();
    }
}