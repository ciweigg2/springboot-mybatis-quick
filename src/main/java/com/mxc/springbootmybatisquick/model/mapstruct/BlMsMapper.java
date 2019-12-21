package com.mxc.springbootmybatisquick.model.mapstruct;

import com.mxc.springbootmybatisquick.model.BlListRequest;
import com.mxc.springbootmybatisquick.mybatis.model.BusinessLicense;
import org.mapstruct.Mapper;

/**
 * @author maxiucheng
 * @className BlMapper
 * @description 电子营业执照查询列表参数映射
 * @date 2019/11/29 10:29 上午
 **/
@Mapper(componentModel = "spring")
public interface BlMsMapper {

    BusinessLicense BlRequestToBusinessLicense(BlListRequest blListRequest);

}
