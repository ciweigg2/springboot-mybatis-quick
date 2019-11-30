package com.mxc.springbootmybatisquick.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mxc.springbootmybatisquick.mybatis.mapper.BusinessLicenseMapper;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import com.mxc.springbootmybatisquick.service.BusinessLicenseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author maxiucheng
 * @className BusinessLicenseServiceImpl
 * @description 测试接口实现
 * @date 2019/11/28 5:33 下午
 * @menu
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class BusinessLicenseServiceImpl extends ServiceImpl<BusinessLicenseMapper, BusinessLicense> implements BusinessLicenseService {

}

