package com.mxc.springbootmybatisquick.model;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import lombok.Data;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className BusinessLicenseDto
 * @description 查询条件
 * @date 2019/12/19 10:09 上午
 * @menu
 **/
@Data
public class BusinessLicenseDTO implements Serializable {

    /**
     * 企业名称
     */
    @BindQuery(comparison = Comparison.STARTSWITH)
    private String entName;

    /**
     * 法定代表人
     */
    @BindQuery(comparison = Comparison.IN, field = "name")
    private String names;

    /**
     * 授权书截止日期 开始
     */
    @BindQuery(comparison = Comparison.BETWEEN_BEGIN, field = "auth_term")
    private String authTermBegin;

    /**
     * 授权书截止日期 截止
     */
    @BindQuery(comparison = Comparison.BETWEEN_END, field = "auth_term")
    private String authTermEnd;

}
