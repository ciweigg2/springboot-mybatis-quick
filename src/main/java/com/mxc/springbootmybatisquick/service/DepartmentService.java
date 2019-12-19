package com.mxc.springbootmybatisquick.service;

import java.util.List;
import com.mxc.springbootmybatisquick.mybatis.model.Department;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 *@className DepartmentService
 *@description
 *@author maxiucheng
 *@date 2019/12/19 5:48 下午
 *@menu
**/
public interface DepartmentService extends IService<Department>{


    int updateBatchSelective(List<Department> list);

}
