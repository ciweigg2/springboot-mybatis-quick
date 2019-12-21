package com.mxc.springbootmybatisquick.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mxc.springbootmybatisquick.mybatis.mapper.UserRoleMapper;
import com.mxc.springbootmybatisquick.mybatis.model.UserRole;
import com.mxc.springbootmybatisquick.service.UserRoleService;

/**
 * @author maxiucheng
 * @className UserRoleServiceImpl
 * @description
 * @date 2019/12/20 10:35 下午
 * @menu
 **/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public int updateBatchSelective(List<UserRole> list) {
        return baseMapper.updateBatchSelective(list);
    }
}

