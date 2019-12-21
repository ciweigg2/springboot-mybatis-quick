package com.mxc.springbootmybatisquick.model.vo;

import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindField;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import com.mxc.springbootmybatisquick.mybatis.model.Department;
import lombok.Data;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className BusinessLicenseListVo
 * @description
 * @date 2019/12/20 9:09 下午
 **/
@Data
public class BusinessLicenseListVO extends BusinessLicense implements Serializable {

    /**
     * 统一社会信用代码名称
     */
    @BindDict(type = "CODE", field = "unIsCid")
    private String unIsCidName;

    /**
     * 统一社会信用代码
     */
    private String unIsCid;

    //会将business_license的主键查出来后用in主键的方式查询关联表 如果查询不到显示null start

    /**
     * 部门名称
     */
    // 字段关联
    @BindField(entity= Department.class, field="name", condition="this.bl_id=id AND parent_id IS NOT NULL")
    private String deptName;

    //会将business_license的主键查出来后用in主键的方式查询关联表 如果查询不到显示null end

}
