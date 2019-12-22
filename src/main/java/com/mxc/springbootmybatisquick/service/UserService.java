package com.mxc.springbootmybatisquick.service;

import com.mxc.springbootmybatisquick.mybatis.model.User;
import com.baomidou.mybatisplus.extension.service.IService;import java.util.List;

/**
 * @author maxiucheng
 * @className UserService
 * @description
 * @date 2019/12/20 10:35 下午
 * @menu
 **/
public interface UserService extends IService<User> {

    int updateBatchSelective(List<User> list);
}

