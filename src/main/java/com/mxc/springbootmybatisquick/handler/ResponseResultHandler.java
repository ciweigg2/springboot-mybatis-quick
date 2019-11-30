package com.mxc.springbootmybatisquick.handler;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.mxc.springbootmybatisquick.annotation.ResponseResult;
import com.mxc.springbootmybatisquick.utils.ResponseView;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author maxiucheng
 * @className ResponseResultHandler
 * @description 重写返回体
 * @date 2019/11/29 8:36 下午
 * @menu
 **/
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 标记名称
     */
    public static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //是否请求包含了包装注解 没有直接返回 如果有就重写返回体
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断请求是否包含标记
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return responseResultAnn == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("override responseview starting");
        if (!(body instanceof ResponseView)) {
            //如果无法转换统一返回说明请求过程是成功的
            return ResponseView.success(body);
        }
        //肯定可以转换ResponseView 其实可以直接else返回body 但是可能以后会有多种情况所以这么写的
        ResponseView responseView = (ResponseView) body;
        Object clazz = responseView.getResult();
        //分页特殊处理 因为要配合yapi生成文档 所以必须特殊处理
        if (clazz instanceof Page) {
            return body;
        } else {
            //如果请求体包含ResponseView说明进入异常处理过了
            return body;
        }
    }

}
