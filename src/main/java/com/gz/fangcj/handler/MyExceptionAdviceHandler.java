package com.gz.fangcj.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ContextValueFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.gz.fangcj.annotation.PhoneHideAnnotation;
import com.gz.fangcj.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

/**
 * 自定义全局异常处理
 *
 * @author Fang chenjiang
 * @create 2021-01-14-15:12
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionAdviceHandler  implements ResponseBodyAdvice {

    /**
     * 异常响应统一返回
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionResponse(Exception exception, WebRequest request) {
        String message = exception.getMessage();
        CommonResult result = CommonResult.failed(message);
        return result;
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //如果在方法上有隐藏手机号的注解
        if (methodParameter.hasMethodAnnotation(PhoneHideAnnotation.class)){
            return true;
        }
        return false;
    }

    /**
     * 手机号加密处理
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof  CommonResult){
            List<String> phoneParam = Lists.newArrayList("phone");
            CommonResult vo=(CommonResult) o;
            ContextValueFilter valueFilter = (context, object, name, value) -> {
                if (phoneParam.contains(name)) {
                    if (value != null) {
                        String phone = value.toString();
                        if (phone.length() > 3) {
                            return phone.substring(0, 3) + "******" + phone.substring(phone.length() - 2);
                        }
                        return phone;
                    }
                    return "";
                } else {
                    return value;
                }
            };
            String jsonOutput = JSON.toJSONString(vo, valueFilter, SerializerFeature.WriteDateUseDateFormat);
            log.info(jsonOutput);
            CommonResult result = JSON.parseObject(jsonOutput, CommonResult.class);
            return result;
        }
        return null;
    }
}
