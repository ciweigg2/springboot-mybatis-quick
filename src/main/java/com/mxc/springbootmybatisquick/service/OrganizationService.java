package com.mxc.springbootmybatisquick.service;

import com.mxc.springbootmybatisquick.mybatis.model.Organization;
import com.baomidou.mybatisplus.extension.service.IService;import java.util.List;

/**
 * @author maxiucheng
 * @className OrganizationService
 * @description
 * @date 2019/12/20 10:35 下午
 * @menu
 **/
public interface OrganizationService extends IService<Organization> {


    int updateBatchSelective(List<Organization> list);
}

