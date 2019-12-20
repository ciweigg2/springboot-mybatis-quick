package com.mxc.springbootmybatisquick.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mxc.springbootmybatisquick.mybatis.model.User;
import com.mxc.springbootmybatisquick.mybatis.mapper.UserMapper;
import com.mxc.springbootmybatisquick.service.UserService;
/**
 *@className UserServiceImpl
 *@description
 *@author maxiucheng
 *@date 2019/12/20 10:35 下午
 *@menu
**/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
