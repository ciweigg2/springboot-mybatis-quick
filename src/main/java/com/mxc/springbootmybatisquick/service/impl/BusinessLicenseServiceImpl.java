package com.mxc.springbootmybatisquick.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mxc.springbootmybatisquick.mybatis.mapper.BusinessLicenseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import com.mxc.springbootmybatisquick.service.BusinessLicenseService;
import org.springframework.stereotype.Service;

/**
 * @author maxiucheng
 * @className BusinessLicenseServiceImpl
 * @description
 * @date 2019/11/28 5:33 下午
 * @menu
 **/
@Service
public class BusinessLicenseServiceImpl extends ServiceImpl<BusinessLicenseMapper, BusinessLicense> implements BusinessLicenseService {

}

