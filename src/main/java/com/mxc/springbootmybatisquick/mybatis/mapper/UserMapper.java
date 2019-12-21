package com.mxc.springbootmybatisquick.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.User;
import java.util.List;

/**
 * @author maxiucheng
 * @className UserMapper
 * @description
 * @date 2019/12/21 4:05 下午
 * @menu
 **/
public interface UserMapper extends BaseMapper<User> {
    int updateBatchSelective(List<User> list);
}