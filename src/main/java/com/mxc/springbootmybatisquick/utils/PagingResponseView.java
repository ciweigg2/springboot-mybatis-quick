package com.mxc.springbootmybatisquick.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mxc.springbootmybatisquick.config.MyIPage;
import com.mxc.springbootmybatisquick.model.mapstruct.MyIPageMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maxiucheng
 * @className PagingResponseView
 * @description 分页返回参数
 * @date 2019/12/20 4:25 下午
 **/
@Data
@NoArgsConstructor
public class PagingResponseView<T> extends ResponseView {

    /***
     * 分页相关信息
     */
    private MyIPage page;

    /**
     * 默认成功，无返回数据
     */
    public PagingResponseView(ResponseView responseView, Page page){
        super(responseView.getResult() ,responseView.isSuccess() ,responseView.getCode() ,responseView.getMessage());
        this.page = MyIPageMapper.INSTANCE.pageToMyIPage(page);
    }

}
