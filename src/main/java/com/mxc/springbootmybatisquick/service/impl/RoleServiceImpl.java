package com.mxc.springbootmybatisquick.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mxc.springbootmybatisquick.mybatis.model.Role;
import com.mxc.springbootmybatisquick.mybatis.mapper.RoleMapper;
import com.mxc.springbootmybatisquick.service.RoleService;
/**
 *@className RoleServiceImpl
 *@description
 *@author maxiucheng
 *@date 2019/12/20 10:35 下午
 *@menu
**/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{

}
