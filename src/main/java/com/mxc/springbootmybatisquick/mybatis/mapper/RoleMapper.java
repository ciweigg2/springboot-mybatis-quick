package com.mxc.springbootmybatisquick.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.Role;
import java.util.List;

/**
 * @author maxiucheng
 * @className RoleMapper
 * @description
 * @date 2019/12/21 4:05 下午
 * @menu
 **/
public interface RoleMapper extends BaseMapper<Role> {
    int updateBatchSelective(List<Role> list);
}