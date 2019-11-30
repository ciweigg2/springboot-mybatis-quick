package com.mxc.springbootmybatisquick.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author maxiucheng
 * @className WebAppConfig
 * @description 拦截器注册
 * @date 2019/11/29 9:17 下午
 * @menu
 **/
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/login");
        super.addInterceptors(registry);
    }

}
