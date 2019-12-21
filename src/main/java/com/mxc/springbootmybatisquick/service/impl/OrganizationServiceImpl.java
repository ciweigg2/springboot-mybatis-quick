package com.mxc.springbootmybatisquick.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mxc.springbootmybatisquick.mybatis.mapper.OrganizationMapper;
import com.mxc.springbootmybatisquick.mybatis.model.Organization;
import com.mxc.springbootmybatisquick.service.OrganizationService;

/**
 * @author maxiucheng
 * @className OrganizationServiceImpl
 * @description
 * @date 2019/12/20 10:35 下午
 * @menu
 **/
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

    @Override
    public int updateBatchSelective(List<Organization> list) {
        return baseMapper.updateBatchSelective(list);
    }
}

