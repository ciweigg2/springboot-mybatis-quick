package com.mxc.springbootmybatisquick.model;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import com.mxc.springbootmybatisquick.mybatis.model.User;
import lombok.Data;

import java.util.Date;

/**
 * @author maxiucheng
 * @className UserDto
 * @description
 * @date 2019/12/20 10:42 下午
 * @menu
 **/
@Data
public class UserDTO extends User {

    @BindQuery(comparison = Comparison.STARTSWITH)
    private String username;

    @BindQuery(comparison = Comparison.IN, field = "gender")
    private String[] genders;

    @BindQuery(comparison = Comparison.BETWEEN_BEGIN, field = "create_time")
    private Date createTimeBegin;

    @BindQuery(comparison = Comparison.BETWEEN_END, field = "create_time")
    private Date createTimeEnd;

}
