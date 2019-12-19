package com.mxc.springbootmybatisquick.model;

import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindField;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import com.mxc.springbootmybatisquick.mybatis.model.Department;
import lombok.Data;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className BusinessLicenseVo
 * @description
 * @date 2019/12/19 4:18 下午
 * @menu
 **/
@Data
public class BusinessLicenseVo extends BusinessLicense implements Serializable {

    @BindDict(type="GENDER", field = "unIsCid")
    private String unIsCidName;

    // 字段关联
    @BindField(entity= Department.class, field="name", condition="this.bl_id=id")
    private String deptName;

}
