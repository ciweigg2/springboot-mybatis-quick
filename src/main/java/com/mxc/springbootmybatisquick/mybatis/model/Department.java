package com.mxc.springbootmybatisquick.mybatis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author maxiucheng
 * @className Department
 * @description
 * @date 2019/12/21 4:05 下午
 * @menu
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "department")
public class Department implements Serializable {
    public static final String COL_BL_ID = "bl_id";
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 上级部门ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 单位ID
     */
    @TableField(value = "org_id")
    private Long orgId;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 扩展字段
     */
    @TableField(value = "extdata")
    private String extdata;

    /**
     * 已删除
     */
    @TableField(value = "is_deleted")
    private Byte isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_ORG_ID = "org_id";

    public static final String COL_NAME = "name";

    public static final String COL_EXTDATA = "extdata";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_CREATE_TIME = "create_time";
}