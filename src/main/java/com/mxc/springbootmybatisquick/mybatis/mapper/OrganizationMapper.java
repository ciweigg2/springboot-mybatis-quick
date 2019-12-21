package com.mxc.springbootmybatisquick.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.Organization;
import java.util.List;

/**
 * @author maxiucheng
 * @className OrganizationMapper
 * @description
 * @date 2019/12/21 4:05 下午
 * @menu
 **/
public interface OrganizationMapper extends BaseMapper<Organization> {
    int updateBatchSelective(List<Organization> list);
}