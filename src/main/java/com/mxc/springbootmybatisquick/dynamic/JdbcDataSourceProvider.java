package com.mxc.springbootmybatisquick.dynamic;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.provider.AbstractDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * @author maxiucheng
 * @className JdbcDataSourceProvider
 * @description 实现从数据库获取数据源
 * @date 2019/12/27 11:02 下午
 **/
@Slf4j
@Component
@Data
public class JdbcDataSourceProvider extends AbstractDataSourceProvider {

    @Value("${dynamic.master.url}")
    private String url;

    @Value("${dynamic.master.username}")
    private String username;

    @Value("${dynamic.master.password}")
    private String password;

    @Value("${dynamic.master.driver-class-name}")
    private String driverClassName;

    /**
     * 加载所有数据源
     *
     * @return 所有数据源，key为数据源名称
     */
    @Override
    public Map<String, DataSource> loadDataSources() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driverClassName);
            log.info("成功加载数据库驱动程序");
            conn = DriverManager.getConnection(url, username, password);
            log.info("成功获取数据库连接");
            stmt = conn.createStatement();
            Map<String, DataSourceProperty> dataSourcePropertiesMap = executeStmt(stmt);
            List<String> list = new ArrayList<>(dataSourcePropertiesMap.keySet());
            log.info("成功加载数据源列表：{}" , JSONObject.toJSONString(list));
            return createDataSourceMap(dataSourcePropertiesMap);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
            JdbcUtils.closeStatement(stmt);
        }
        return null;
    }

    /**
     * 执行语句获得数据源参数
     *
     * @param statement 语句
     * @return 数据源参数
     * @throws SQLException sql异常
     */
    protected Map<String, DataSourceProperty> executeStmt(Statement statement)
            throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from datasource");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        Map<String ,DataSourceProperty> dataSourcePropertyMap = Maps.newHashMap();
        while (resultSet.next()) {
            Map<String ,Object> rowData = new HashMap();
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }
            HashMap<String, String> mapping = CollUtil.newHashMap();
            mapping.put("id", "id");
            mapping.put("drive_class_name", "driveClassName");
            mapping.put("url", "url");
            mapping.put("user_name", "username");
            mapping.put("password", "password");
            mapping.put("poll_name", "pollName");
            DataSourceProperty dataSourceProperty = BeanUtil.mapToBean(rowData, DataSourceProperty.class, CopyOptions.create().setFieldMapping(mapping));
            dataSourcePropertyMap.put(dataSourceProperty.getPollName() ,dataSourceProperty);
        }
        return dataSourcePropertyMap;
    }

}
