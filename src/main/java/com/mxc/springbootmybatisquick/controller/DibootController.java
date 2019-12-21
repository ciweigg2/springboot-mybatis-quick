package com.mxc.springbootmybatisquick.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.diboot.core.binding.QueryBuilder;
import com.diboot.core.binding.RelationsBinder;
import com.mxc.springbootmybatisquick.config.MyIPage;
import com.mxc.springbootmybatisquick.config.MybatisPlusPage;
import com.mxc.springbootmybatisquick.model.dto.BusinessLicenseDTO;
import com.mxc.springbootmybatisquick.model.dto.UserDTO;
import com.mxc.springbootmybatisquick.model.vo.BusinessLicenseListVO;
import com.mxc.springbootmybatisquick.model.vo.BusinessLicenseVO;
import com.mxc.springbootmybatisquick.model.vo.UserVO;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import com.mxc.springbootmybatisquick.mybatis.model.User;
import com.mxc.springbootmybatisquick.service.BusinessLicenseService;
import com.mxc.springbootmybatisquick.service.UserService;
import com.mxc.springbootmybatisquick.utils.BusinessException;
import com.mxc.springbootmybatisquick.utils.ResponseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Diboot测试接口
 *
 * @author maxiucheng
 * @className DibootController
 * @description Diboot测试接口
 * @date 2019/12/20 2:01 下午
 * @menu diboot
 **/
@RestController
@RequestMapping(value = "/diboot")
@Validated
public class DibootController {

    @Autowired
    private BusinessLicenseService businessLicenseService;

    @Autowired
    private UserService userService;

    /**
     * 查询VO的分页数据，此例同时示例DTO自动绑定转换为QueryWrapper，查询条件为空不会拼接的 （简单版）
     *
     * @param mybatisPlusPage mybatis +页面
     * @return {@link ResponseView<MyIPage<BusinessLicenseListVO>> }
     * @author maxiucheng
     * @date 2019/12/21 10:59:23
     * @description 查询VO的分页数据，此例同时示例DTO自动绑定转换为QueryWrapper，查询条件为空不会拼接的 （简单版）
     * @status 已发布
     */
    @PostMapping("/listWithDto")
    public ResponseView<MyIPage<BusinessLicenseListVO>> getVOListWithDTO(@RequestBody MybatisPlusPage<BusinessLicenseDTO> mybatisPlusPage) {
        // DTO转换为QueryWrapper，若无@BindQuery注解默认映射为等于=条件，有注解映射为注解条件。
        QueryWrapper<BusinessLicense> queryWrapper = QueryBuilder.toQueryWrapper(mybatisPlusPage.getObject());
        // 查询当前页的Entity主表数据
        Page<BusinessLicense> page = new Page<>(mybatisPlusPage.getCurrent(), mybatisPlusPage.getSize());
        //排序
        page.setOrders(mybatisPlusPage.getOrders());
        Page<BusinessLicense> businessLicensePage = businessLicenseService.page(page, queryWrapper);
        // 自动转换VO中注解绑定的关联
        List<BusinessLicenseListVO> voList = RelationsBinder.convertAndBind(businessLicensePage.getRecords(), BusinessLicenseListVO.class);
        // 返回结果
        return ResponseView.success(voList).bindPagination(businessLicensePage);
    }

    /**
     * 查询VO的分页数据，此例同时示例DTO自动绑定转换为QueryWrapper，查询条件为空不会拼接的 （复杂版）
     *
     * @param mybatisPlusPage mybatis +页面
     * @return {@link ResponseView<MyIPage<UserVO>> }
     * @author maxiucheng
     * @date 2019/12/21 10:59:56
     * @description 查询VO的分页数据，此例同时示例DTO自动绑定转换为QueryWrapper，查询条件为空不会拼接的 （复杂版）
     * @status 已发布
     */
    @PostMapping("/listWithDto2")
    public ResponseView<MyIPage<UserVO>> getVOListWithDTO2(@RequestBody MybatisPlusPage<UserDTO> mybatisPlusPage) {
        // DTO转换为QueryWrapper，若无@BindQuery注解默认映射为等于=条件，有注解映射为注解条件。
        QueryWrapper<User> queryWrapper = QueryBuilder.toQueryWrapper(mybatisPlusPage.getObject());
        // 查询当前页的Entity主表数据
        Page<User> page = new Page<>(mybatisPlusPage.getCurrent(), mybatisPlusPage.getSize());
        //排序
        page.setOrders(mybatisPlusPage.getOrders());
        Page<User> userPage = userService.page(page, queryWrapper);
        // 自动转换VO中注解绑定的关联
        List<UserVO> voList = RelationsBinder.convertAndBind(userPage.getRecords(), UserVO.class);
        // 返回结果
        return ResponseView.success(voList).bindPagination(page);
    }

    /**
     * 查询返回自定义vo 不继承数据库bean的方式
     *
     * @param blId 电子营业执照主键
     * @return {@link ResponseView<List<BusinessLicenseVO>> }
     * @author maxiucheng
     * @date 2019/12/20 18:04:31
     * @description 查询返回自定义vo 不继承数据库bean的方式
     * @status 已发布
     */
    @PostMapping(value = "/selectVo")
    public ResponseView<List<BusinessLicenseVO>> selectVo(@RequestParam(value = "blId") @NotEmpty(message = "blId不能为空") String blId){
        //测试单条记录
        BusinessLicense businessLicense = businessLicenseService.getById(blId);
        Optional.ofNullable(businessLicense).orElseThrow(()->new BusinessException("未查询到数据"));
        List<BusinessLicenseVO> businessLicenseVoList = RelationsBinder.convertAndBind(Arrays.asList(businessLicense), BusinessLicenseVO.class);
        BusinessLicenseVO businessLicenseVo = businessLicenseVoList.get(0);
        System.out.println("单条记录：" + JSONObject.toJSONString(businessLicenseVo));
        //测试多条记录
        List<BusinessLicense> businessLicenseList = businessLicenseService.list();
        List<BusinessLicenseVO> businessLicenseVos = RelationsBinder.convertAndBind(businessLicenseList, BusinessLicenseVO.class);
        System.out.println("多条记录：" + JSONObject.toJSONString(businessLicenseVos));
        return ResponseView.success(businessLicenseVos);
    }

}
