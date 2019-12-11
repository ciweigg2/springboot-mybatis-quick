package com.mxc.springbootmybatisquick.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
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
import org.springframework.web.bind.annotation.*;

/**
 * 电子营业执照Controller
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
     * 查询电子营业执照列表
     * @author maxiucheng
     * @date 2019/11/28 12:09 下午
     * @description 查询电子营业执照列表
     * @param mybatisPlusPage 分页条件
     * @return {@link MyIPage<BusinessLicense>}
     **/
    @PostMapping(value = "/list")
    public ResponseView<MyIPage<BusinessLicense>> list(@RequestBody MybatisPlusPage<BlListRequest> mybatisPlusPage) {
        QueryWrapper<BusinessLicense> wrapper = new QueryWrapper();
        //根据不为空的字段查询 反射复制太慢 所以采用这种方式
        BusinessLicense businessLicense = blMsMapper.BlRequestToBusinessLicense(mybatisPlusPage.getObject());
        wrapper.setEntity(businessLicense);
        Page<BusinessLicense> page = new Page<>(mybatisPlusPage.getCurrent() ,mybatisPlusPage.getSize());
        return ResponseView.success(businessLicenseService.page(page ,wrapper));
    }

    /**
     * mybatis强大的功能
     *
     * @return {@link Void}
     * @author maxiucheng
     * @date 2019/12/11 16:54:27
     * @description 测试
     * @status 已发布
     */
    @GetMapping(value = "/test")
    public void test(){
//        UPDATE business_license SET ent_name='额外飞舞的地方威风威风', auth_term='123123' WHERE (bl_id = '1');
        BusinessLicense businessLicense = new BusinessLicense();
        businessLicense.setAuthTerm("123123");
        businessLicense.setEntName("额外飞舞的地方威风威风");
        LambdaUpdateWrapper<BusinessLicense> objectLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        objectLambdaUpdateWrapper.eq(true ,BusinessLicense::getBlId ,"1");
        businessLicenseService.update(businessLicense ,objectLambdaUpdateWrapper);
    }
    
}
