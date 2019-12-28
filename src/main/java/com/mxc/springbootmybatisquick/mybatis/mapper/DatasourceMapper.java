package com.mxc.springbootmybatisquick.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.Datasource;
import java.util.List;

/**
 * @author maxiucheng
 * @className DatasourceMapper
 * @description
 * @date 2019/12/27 11:22 下午
 * @menu
 **/
public interface DatasourceMapper extends BaseMapper<Datasource> {
    int updateBatchSelective(List<Datasource> list);
}