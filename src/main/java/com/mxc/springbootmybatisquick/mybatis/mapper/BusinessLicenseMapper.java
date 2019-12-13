package com.mxc.springbootmybatisquick.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import java.util.List;

/**
 * @author maxiucheng
 * @className BusinessLicenseMapper
 * @description
 * @date 2019/12/13 9:53 下午
 * @menu
 **/
public interface BusinessLicenseMapper extends BaseMapper<BusinessLicense> {

    int updateBatchSelective(List<BusinessLicense> list);

}