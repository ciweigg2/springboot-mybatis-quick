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
 * @className BusinessLicense
 * @description
 * @date 2019/12/13 9:53 下午
 * @menu
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "business_license")
public class BusinessLicense implements Serializable {
    /**
     * 系统授权码
     */
    @TableId(value = "bl_id", type = IdType.INPUT)
    private String blId;

    /**
     * 企业名称
     */
    @TableField(value = "ent_name")
    private String entName;

    /**
     * 统一社会信用代码
     */
    @TableField(value = "un_is_cid")
    private String unIsCid;

    /**
     * 法定代表人
     */
    @TableField(value = "name")
    private String name;

    /**
     * 经办人
     */
    @TableField(value = "oper")
    private String oper;

    /**
     * 授权书截止日期
     */
    @TableField(value = "auth_term")
    private String authTerm;

    /**
     * 电子营业执照授权书下载地址
     */
    @TableField(value = "image_url")
    private String imageUrl;

    private static final long serialVersionUID = 1L;

    public static final String COL_BL_ID = "bl_id";

    public static final String COL_ENT_NAME = "ent_name";

    public static final String COL_UN_IS_CID = "un_is_cid";

    public static final String COL_NAME = "name";

    public static final String COL_OPER = "oper";

    public static final String COL_AUTH_TERM = "auth_term";

    public static final String COL_IMAGE_URL = "image_url";
}