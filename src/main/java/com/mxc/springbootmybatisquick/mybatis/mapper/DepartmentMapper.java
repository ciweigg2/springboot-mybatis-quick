package com.mxc.springbootmybatisquick.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.Department;
import java.util.List;

/**
 * @author maxiucheng
 * @className DepartmentMapper
 * @description
 * @date 2019/12/21 4:05 下午
 * @menu
 **/
public interface DepartmentMapper extends BaseMapper<Department> {
    int updateBatchSelective(List<Department> list);
}