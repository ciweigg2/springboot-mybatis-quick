package com.mxc.springbootmybatisquick.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.UserRole;
import java.util.List;

/**
 * @author maxiucheng
 * @className UserRoleMapper
 * @description
 * @date 2019/12/21 4:05 下午
 * @menu
 **/
public interface UserRoleMapper extends BaseMapper<UserRole> {
    int updateBatchSelective(List<UserRole> list);
}