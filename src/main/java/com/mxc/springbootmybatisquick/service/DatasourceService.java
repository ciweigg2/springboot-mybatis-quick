package com.mxc.springbootmybatisquick.service;

import java.util.List;
import com.mxc.springbootmybatisquick.mybatis.model.Datasource;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author maxiucheng
 * @className DatasourceService
 * @description
 * @date 2019/12/27 11:10 下午
 * @menu
 **/
public interface DatasourceService extends IService<Datasource> {


    int updateBatchSelective(List<Datasource> list);

}


