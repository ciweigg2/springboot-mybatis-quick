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
 * @className Datasource
 * @description
 * @date 2019/12/27 11:22 下午
 * @menu
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "datasource")
public class Datasource implements Serializable {
    /**
     * 数据源编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 驱动名
     */
    @TableField(value = "drive_class_name")
    private String driveClassName;

    /**
     * 数据库地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 连接名
     */
    @TableField(value = "poll_name")
    private String pollName;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_DRIVE_CLASS_NAME = "drive_class_name";

    public static final String COL_URL = "url";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_PASSWORD = "password";

    public static final String COL_POLL_NAME = "poll_name";
}