package com.mxc.springbootmybatisquick.model.mapstruct;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mxc.springbootmybatisquick.config.MyIPage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author maxiucheng
 * @className MyIPageMapper
 * @description 分页转换信息 （为了生成文档）
 * @date 2019/12/21 1:20 下午
 **/
@Mapper
public interface MyIPageMapper {

    MyIPageMapper INSTANCE = Mappers.getMapper(MyIPageMapper.class);

    MyIPage pageToMyIPage(Page page);

}
