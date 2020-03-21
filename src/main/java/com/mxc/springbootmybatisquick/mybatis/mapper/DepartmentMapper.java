package com.mxc.springbootmybatisquick.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mxc.springbootmybatisquick.mybatis.model.Department;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author maxiucheng
 * @className DepartmentMapper
 * @description
 * @date 2019/12/21 4:05 下午
 * @menu
 **/
public interface DepartmentMapper extends BaseMapper<Department> {

    int updateBatchSelective(List<Department> list);

    //多表联合查询(没有sql注入的风险)
    @Select("select t1.*,t2.name,t2.create_time from department t1 LEFT JOIN  organization t2  ON t1.id =t2.id WHERE t1.id= #{id}")
    List<Map<String,Object>> doList(Page<Map<String,Object>> page, String id);

}