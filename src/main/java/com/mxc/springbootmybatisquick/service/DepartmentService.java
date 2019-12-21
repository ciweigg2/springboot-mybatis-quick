package com.mxc.springbootmybatisquick.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mxc.springbootmybatisquick.mybatis.model.Department;import java.util.List;

/**
 * @author maxiucheng
 * @className DepartmentService
 * @description
 * @date 2019/12/19 5:48 下午
 * @menu
 **/
public interface DepartmentService extends IService<Department> {

    int updateBatchSelective(List<Department> list);
}







