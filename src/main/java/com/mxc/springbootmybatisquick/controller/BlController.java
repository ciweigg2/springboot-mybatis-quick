package com.mxc.springbootmybatisquick.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mxc.springbootmybatisquick.annotation.ResponseResult;
import com.mxc.springbootmybatisquick.config.MyIPage;
import com.mxc.springbootmybatisquick.config.MybatisPlusPage;
import com.mxc.springbootmybatisquick.model.BlListRequest;
import com.mxc.springbootmybatisquick.model.mapstruct.BlMsMapper;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import com.mxc.springbootmybatisquick.service.BusinessLicenseService;
import com.mxc.springbootmybatisquick.utils.ResponseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className BlController
 * @description 电子营业执照Controller
 * @author maxiucheng
 * @date 2019/11/28 12:07 下午
 * @menu 电子营业执照接口
 **/
@RestController
@RequestMapping(value = "/api")
@ResponseResult
public class BlController {

    @Autowired
    private BusinessLicenseService businessLicenseService;

    @Autowired
    private BlMsMapper blMsMapper;
    
    /**
     * @author maxiucheng
     * @date 2019/11/28 12:09 下午
     * @description 查询电子营业执照列表
     * @param mybatisPlusPage: 分页条件
     * @return {@link MyIPage<BusinessLicense>}
     **/
    @PostMapping(value = "/list")
    public ResponseView<MyIPage<BusinessLicense>> list(@RequestBody MybatisPlusPage<BlListRequest> mybatisPlusPage) throws Exception {
        QueryWrapper<BusinessLicense> wrapper = new QueryWrapper();
        //根据不为空的字段查询 反射复制太慢 所以采用这种方式
        BusinessLicense businessLicense = blMsMapper.BlRequestToBusinessLicense(mybatisPlusPage.getObject());
        wrapper.setEntity(businessLicense);
        Page<BusinessLicense> page = new Page<>(mybatisPlusPage.getCurrent() ,mybatisPlusPage.getSize());
        return ResponseView.success(businessLicenseService.page(page ,wrapper));
    }
    
}
