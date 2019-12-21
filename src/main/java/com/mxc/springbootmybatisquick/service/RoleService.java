package com.mxc.springbootmybatisquick.service;

import com.mxc.springbootmybatisquick.mybatis.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;import java.util.List;

/**
 * @author maxiucheng
 * @className RoleService
 * @description
 * @date 2019/12/20 10:35 下午
 * @menu
 **/
public interface RoleService extends IService<Role> {


    int updateBatchSelective(List<Role> list);
}

