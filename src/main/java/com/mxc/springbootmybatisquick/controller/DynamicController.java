package com.mxc.springbootmybatisquick.controller;

import com.baomidou.dynamic.datasource.DynamicDataSourceCreator;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.diboot.core.binding.QueryBuilder;
import com.diboot.core.binding.RelationsBinder;
import com.mxc.springbootmybatisquick.config.MyIPage;
import com.mxc.springbootmybatisquick.config.MybatisPlusPage;
import com.mxc.springbootmybatisquick.model.dto.UserDTO;
import com.mxc.springbootmybatisquick.model.vo.UserVO;
import com.mxc.springbootmybatisquick.mybatis.model.Datasource;
import com.mxc.springbootmybatisquick.mybatis.model.User;
import com.mxc.springbootmybatisquick.service.DatasourceService;
import com.mxc.springbootmybatisquick.service.UserService;
import com.mxc.springbootmybatisquick.utils.ResponseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;
import java.util.Set;

/**
 * @author maxiucheng
 * @className DynamicController
 * @description 动态删减数据源测试类
 * @date 2019/12/28 1:31 下午
 * @menu
 **/
@RestController
@RequestMapping(value = "/dynamic")
public class DynamicController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DynamicDataSourceCreator dataSourceCreator;

    @Autowired
    private DatasourceService datasourceService;

    /**
     * 查询VO的分页数据，此例同时示例DTO自动绑定转换为QueryWrapper，查询条件为空不会拼接的 （复杂版）
     *
     * @param mybatisPlusPage mybatis +页面
     * @return {@link ResponseView<MyIPage<UserVO>> }
     * @author maxiucheng
     * @date 2019/12/21 10:59:56
     * @description 查询VO的分页数据，此例同时示例DTO自动绑定转换为QueryWrapper，查询条件为空不会拼接的 （复杂版）
     * @status 已发布
     */
    @PostMapping("/listWithDto2")
    public ResponseView<MyIPage<UserVO>> getVOListWithDTO2(@RequestBody MybatisPlusPage<UserDTO> mybatisPlusPage) {
        // DTO转换为QueryWrapper，若无@BindQuery注解默认映射为等于=条件，有注解映射为注解条件。
        QueryWrapper<User> queryWrapper = QueryBuilder.toQueryWrapper(mybatisPlusPage.getObject());
        // 查询当前页的Entity主表数据
        Page<User> page = new Page<>(mybatisPlusPage.getCurrent(), mybatisPlusPage.getSize());
        //排序
        page.setOrders(mybatisPlusPage.getOrders());
        Page<User> userPage = userService.page(page, queryWrapper);
        // 自动转换VO中注解绑定的关联
        List<UserVO> voList = RelationsBinder.convertAndBind(userPage.getRecords(), UserVO.class);
        // 返回结果
        return ResponseView.success(voList).bindPagination(page);
    }

    /**
     * 获取数据源
     *
     * @return {@link Set<String> }
     * @author maxiucheng
     * @date 2019/12/28 14:34:36
     * @description 获取数据源
     * @status 已发布
     */
    @GetMapping
    public Set<String> now() {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        return ds.getCurrentDataSources().keySet();
    }

    /**
     * 添加数据源
     *
     * @param dataSourceProperty 数据源属性
     * @return {@link Set<String> }
     * @author maxiucheng
     * @date 2019/12/28 14:34:56
     * @description 添加数据源
     * @status 已发布
     */
    @PostMapping
    public Set<String> add(@RequestBody DataSourceProperty dataSourceProperty) {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
        ds.addDataSource(dataSourceProperty.getPollName(), dataSource);
        //将数据源添加到数据库
        Datasource db = new Datasource();
        db.setDriveClassName(dataSourceProperty.getDriverClassName());
        db.setUrl(dataSourceProperty.getUrl());
        db.setUserName(dataSourceProperty.getUsername());
        db.setPassword(dataSourceProperty.getPassword());
        db.setPollName(dataSourceProperty.getPollName());
        datasourceService.saveOrUpdate(db ,new LambdaUpdateWrapper<Datasource>().eq(true ,Datasource::getPollName ,db.getPollName()));
        return ds.getCurrentDataSources().keySet();
    }

    /**
     * 删除数据源
     *
     * @param name 数据源名称
     * @return
     * @author maxiucheng
     * @date 2019/12/28 14:35:09
     * @description 删除数据源
     * @status 已发布
     */
    @DeleteMapping
    public void remove(String name) {
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        ds.removeDataSource(name);
        datasourceService.remove(new LambdaQueryWrapper<Datasource>().eq(true ,Datasource::getPollName ,name));
    }

}
