package com.mxc.springbootmybatisquick.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.mxc.springbootmybatisquick.mybatis.mapper.DatasourceMapper;
import com.mxc.springbootmybatisquick.mybatis.model.Datasource;
import com.mxc.springbootmybatisquick.service.DatasourceService;

/**
 * @author maxiucheng
 * @className DatasourceServiceImpl
 * @description
 * @date 2019/12/27 11:10 下午
 * @menu
 **/
@Service
public class DatasourceServiceImpl extends ServiceImpl<DatasourceMapper, Datasource> implements DatasourceService {

    @Override
    public int updateBatchSelective(List<Datasource> list) {
        return baseMapper.updateBatchSelective(list);
    }
}


