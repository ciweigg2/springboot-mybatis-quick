package com.mxc.springbootmybatisquick.model.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import lombok.Data;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className BusinessLicenseDto
 * @description 查询条件
 * @date 2019/12/19 10:09 上午
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
    @BindQuery(comparison = Comparison.IN, field = BusinessLicense.COL_NAME)
    private String names;

    /**
     * 授权书截止日期 开始
     */
    @BindQuery(comparison = Comparison.BETWEEN_BEGIN, field = BusinessLicense.COL_AUTH_TERM)
    private String authTermBegin;

    /**
     * 授权书截止日期 截止
     */
    @BindQuery(comparison = Comparison.BETWEEN_END, field = BusinessLicense.COL_AUTH_TERM)
    private String authTermEnd;

}
