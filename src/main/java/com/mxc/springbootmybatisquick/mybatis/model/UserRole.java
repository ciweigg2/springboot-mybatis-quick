package com.mxc.springbootmybatisquick.mybatis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maxiucheng
 * @className UserRole
 * @description
 * @date 2019/12/21 4:05 下午
 * @menu
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_role")
public class UserRole implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    private Integer userId;

    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.INPUT)
    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_ROLE_ID = "role_id";
}