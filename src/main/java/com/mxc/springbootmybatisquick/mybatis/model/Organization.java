package com.mxc.springbootmybatisquick.mybatis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@className Organization
 *@description
 *@author maxiucheng
 *@date 2019/12/20 10:35 下午
 *@menu
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "organization")
public class Organization implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 上级单位ID
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 电话
     */
    @TableField(value = "telphone")
    private String telphone;

    /**
     * 是否有效
     */
    @TableField(value = "is_deleted")
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_NAME = "name";

    public static final String COL_TELPHONE = "telphone";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_CREATE_TIME = "create_time";
}