package com.mxc.springbootmybatisquick.model.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import com.mxc.springbootmybatisquick.mybatis.model.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author maxiucheng
 * @className UserDto
 * @description
 * @date 2019/12/20 10:42 下午
 **/
@Data
public class UserDTO implements Serializable {

    /**
     * 用户名
     */
    @BindQuery(comparison = Comparison.STARTSWITH)
    private String username;

    /**
     * 性别
     */
    @BindQuery(comparison = Comparison.IN, field = User.COL_GENDER)
    private String[] genders;

    /**
     * 创建开始时间
     */
    @BindQuery(comparison = Comparison.BETWEEN_BEGIN, field = User.COL_CREATE_TIME)
    private Date createTimeBegin;

    /**
     * 创建结束时间
     */
    @BindQuery(comparison = Comparison.BETWEEN_END, field = User.COL_CREATE_TIME)
    private Date createTimeEnd;

}
