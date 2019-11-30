package com.mxc.springbootmybatisquick.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author maxiucheng
 * @className MybatisPlusConfig
 * @description
 * @date 2019/11/28 5:24 下午
 * @menu
 **/
@Configuration
@MapperScan(basePackages = "com.mxc.springbootmybatisquick.mybatis.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
