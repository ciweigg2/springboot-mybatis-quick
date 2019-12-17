package com.mxc.springbootmybatisquick.controller;

import com.mxc.springbootmybatisquick.dynamic.DataSourceRefresher;
import com.mxc.springbootmybatisquick.utils.ResponseView;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.*;

/**
 * @author maxiucheng
 * @className DynamicRefreshController
 * @description 刷新数据源
 * @date 2019/12/17 4:00 下午
 **/
@RestController
@RequestMapping(value = "/datasource")
public class DynamicRefreshController {

    @Autowired
    private DataSourceRefresher dataSourceRefresher;

    /**
     * 刷新数据源
     *
     * @param url 数据库连接
     * @param userName 用户名
     * @param password 用户密码
     * @return 返回信息
     */
    @PostMapping(value = "/refresh")
    public ResponseView<String> refresh(String url ,String userName ,String password){
        DataSourceProperties properties = new DataSourceProperties();
        //修改属性
        properties.setUrl(url);
        properties.setUsername(userName);
        properties.setPassword(password);
        HikariDataSource dataSource = properties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
        dataSourceRefresher.refreshDataSource(dataSource);
        return ResponseView.success("刷新成功");
    }

}
