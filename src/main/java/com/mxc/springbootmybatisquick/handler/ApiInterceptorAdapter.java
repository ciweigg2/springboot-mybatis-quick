package com.mxc.springbootmybatisquick.handler;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author maxiucheng
 * @className ApiInterceptorAdapter
 * @description 动态数据源拦截器
 * @date 2019/12/28 1:49 下午
 **/
@Slf4j
@Component
public class ApiInterceptorAdapter extends HandlerInterceptorAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        String ds = httpServletRequest.getHeader("ds");
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        //设置当前数据源
        DynamicDataSourceContextHolder.push(ds);
        //查看数据源中是否包含当前请求数据源
        DynamicRoutingDataSource dynamicRoutingDataSource = (DynamicRoutingDataSource) dataSource;
        boolean isContains = dynamicRoutingDataSource.getCurrentDataSources().keySet().contains(ds);
        if(isContains){
            log.info("preHandle：请求的uri为：{} ,当前数据源为：{}", requestURL.toString(), ds);
        }else {
            log.info("preHandle：请求的uri为：{} ,因为数据源{}不存在 ，选择默认master数据源", requestURL.toString(), ds);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
        //清除数据源
        DynamicDataSourceContextHolder.clear();
        log.info("postHandle：请求结束清除当前线程数据源");
    }


}
