package com.mxc.springbootmybatisquick.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.diboot.core.binding.QueryBuilder;
import com.diboot.core.binding.RelationsBinder;
import com.diboot.core.service.DictionaryService;
import com.mxc.springbootmybatisquick.annotation.ResponseResult;
import com.mxc.springbootmybatisquick.config.MyIPage;
import com.mxc.springbootmybatisquick.config.MybatisPlusPage;
import com.mxc.springbootmybatisquick.model.BlListRequest;
import com.mxc.springbootmybatisquick.model.BusinessLicenseDto;
import com.mxc.springbootmybatisquick.model.BusinessLicenseVo;
import com.mxc.springbootmybatisquick.model.mapstruct.BlMsMapper;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import com.mxc.springbootmybatisquick.service.BusinessLicenseService;
import com.mxc.springbootmybatisquick.utils.ResponseView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.testng.collections.Lists;

import java.util.List;

/**
 * 电子营业执照Controller
 *
 * @author maxiucheng
 * @className BlController
 * @description 电子营业执照Controller
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

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 查询电子营业执照列表
     *
     * @param mybatisPlusPage 分页条件
     * @return {@link MyIPage<BusinessLicense>}
     * @author maxiucheng
     * @date 2019/11/28 12:09 下午
     * @description 查询电子营业执照列表
     **/
    @PostMapping(value = "/list")
    public ResponseView<MyIPage<BusinessLicense>> list(@RequestBody MybatisPlusPage<BlListRequest> mybatisPlusPage) {
        BlListRequest object = mybatisPlusPage.getObject();
        BusinessLicenseDto businessLicenseDto = new BusinessLicenseDto();
        BeanUtils.copyProperties(object ,businessLicenseDto);
        QueryWrapper<BusinessLicense> wrapper = QueryBuilder.toQueryWrapper(businessLicenseDto);
        wrapper.nested(i -> i.eq("name", "测试").or().ne("ent_name", "1")).eq("bl_id" ,"123");
        //根据不为空的字段查询 反射复制太慢 所以采用这种方式
        BusinessLicense businessLicense = blMsMapper.BlRequestToBusinessLicense(mybatisPlusPage.getObject());
        Page<BusinessLicense> page = new Page<>(mybatisPlusPage.getCurrent(), mybatisPlusPage.getSize());
        List<BusinessLicenseVo> businessLicenseVos = RelationsBinder.convertAndBind(businessLicenseService.page(page, null).getRecords(), BusinessLicenseVo.class);
        return ResponseView.success(businessLicenseVos);
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
    public void test() {
//        UPDATE business_license SET ent_name='额外飞舞的地方威风威风', auth_term='123123' WHERE (bl_id = '1');
//        BusinessLicense businessLicense = new BusinessLicense();
//        businessLicense.setAuthTerm("123123");
//        businessLicense.setEntName("额外飞舞的地方威风威风");
//        LambdaUpdateWrapper<BusinessLicense> objectLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//        objectLambdaUpdateWrapper.eq(true ,BusinessLicense::getBlId ,"1");
//        businessLicenseService.update(businessLicense ,objectLambdaUpdateWrapper);
        //update business_license set ent_name = case when bl_id = '0' then '撒大声地所的多多' when bl_id = '1' then '撒大声地所的多多' when bl_id = '2' then '撒大声地所的多多' when bl_id = '3' then '撒大声地所的多多' when bl_id = '4' then '撒大声地所的多多' end
        // WHERE bl_id in ( '0' , '1' , '2' , '3' , '4' );
        List<BusinessLicense> businessLicenseList = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            BusinessLicense businessLicense = new BusinessLicense();
            businessLicense.setBlId(String.valueOf(i));
            businessLicense.setEntName("撒大声地所的多多");
            businessLicenseList.add(businessLicense);
        }
        businessLicenseService.updateBatchSelective(businessLicenseList);
    }

}
