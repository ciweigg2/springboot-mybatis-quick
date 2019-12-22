package com.mxc.springbootmybatisquick.service;

import com.mxc.springbootmybatisquick.mybatis.model.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;import java.util.List;

/**
 * @author maxiucheng
 * @className UserRoleService
 * @description
 * @date 2019/12/20 10:35 下午
 * @menu
 **/
public interface UserRoleService extends IService<UserRole> {

    int updateBatchSelective(List<UserRole> list);
}

