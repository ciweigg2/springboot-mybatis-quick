package com.mxc.springbootmybatisquick.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.Department;
import java.util.List;

/**
 *@className DepartmentMapper
 *@description
 *@author maxiucheng
 *@date 2019/12/19 5:48 下午
 *@menu
**/
public interface DepartmentMapper extends BaseMapper<Department> {
    int updateBatchSelective(List<Department> list);
}