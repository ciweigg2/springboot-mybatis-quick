package com.mxc.springbootmybatisquick.handler;

import lombok.extern.slf4j.Slf4j;
import com.mxc.springbootmybatisquick.annotation.ResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author maxiucheng
 * @className ResponseResultInterceptor
 * @description 拦截请求，是否此请求返回的值需要包装，其实就是运行的时候，解析@ResponseResult注解
 * @date 2019/11/29 6:03 下午
 * @menu
 **/
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    /**
     * 标记名称
     */
    public static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //请求的方法
        if (handler instanceof HandlerMethod){
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            // TODO: 2019/11/29 可以做个缓存不需要每次都反射操作的 
             Method method = ((HandlerMethod) handler).getMethod();
            //判断是否在类对象上加了注解 或者方法体上有注解
            if (clazz.isAnnotationPresent(ResponseResult.class) || method.isAnnotationPresent(ResponseResult.class)){
                //设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
                request.setAttribute(RESPONSE_RESULT_ANN, clazz.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }

}
