package com.mxc.springbootmybatisquick.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mxc.springbootmybatisquick.mybatis.mapper.DepartmentMapper;
import com.mxc.springbootmybatisquick.mybatis.model.Department;
import com.mxc.springbootmybatisquick.service.DepartmentService;
import org.springframework.stereotype.Service;import java.util.List;

/**
 * @author maxiucheng
 * @className DepartmentServiceImpl
 * @description
 * @date 2019/12/19 5:48 下午
 * @menu
 **/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
    public int updateBatchSelective(List<Department> list) {
        return baseMapper.updateBatchSelective(list);
    }
}







