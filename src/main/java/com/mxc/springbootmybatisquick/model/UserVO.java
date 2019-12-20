package com.mxc.springbootmybatisquick.model;

import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntity;
import com.diboot.core.binding.annotation.BindEntityList;
import com.diboot.core.binding.annotation.BindField;
import com.mxc.springbootmybatisquick.mybatis.model.Department;
import com.mxc.springbootmybatisquick.mybatis.model.Organization;
import com.mxc.springbootmybatisquick.mybatis.model.Role;
import com.mxc.springbootmybatisquick.mybatis.model.User;
import lombok.Data;

import java.util.List;

/**
 * @author maxiucheng
 * @className UserVO
 * @description
 * @date 2019/12/20 10:36 下午
 * @menu
 **/
@Data
public class UserVO extends User {

    //会将business_license的主键查出来后用in主键的方式查询关联表 如果查询不到显示null start

    // 绑定数据字典枚举
    @BindDict(type="GENDER", field = "gender")
    private String genderLabel;

    // 字段关联
    @BindField(entity= Department.class, field="name", condition="this.department_id=id AND parent_id IS NOT NULL")
    private String deptName;

    // 支持级联字段关联，相同条件的entity+condition将合并为一条SQL查询
    @BindField(entity = Organization.class, field="name", condition="this.department_id=department.id AND department.org_id=id")
    private String orgName;
    @BindField(entity = Organization.class, field="telphone", condition="this.department_id=department.id AND department.org_id=id")
    private String orgTelphone;

    // 通过中间表关联Entity
    @BindEntity(entity = Organization.class, condition = "this.department_id=department.id AND department.org_id=id")
    private Organization organization;

    // 支持通过中间表的多-多Entity实体关联
    @BindEntityList(entity = Role.class, condition="this.id=user_role.user_id AND user_role.role_id=id")
    private List<Role> roleList;

    //会将business_license的主键查出来后用in主键的方式查询关联表 如果查询不到显示null end

}
