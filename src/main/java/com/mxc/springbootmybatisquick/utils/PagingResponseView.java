package com.mxc.springbootmybatisquick.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maxiucheng
 * @className PagingResponseView
 * @description 分页返回参数
 * @date 2019/12/20 4:25 下午
 * @menu
 **/
@Data
@NoArgsConstructor
public class PagingResponseView extends ResponseView {

    /***
     * 分页相关信息
     */
    private IPage iPage;

    /**
     * 默认成功，无返回数据
     */
    public PagingResponseView(ResponseView responseView, IPage iPage){
        super(responseView.getResult() ,responseView.isSuccess() ,responseView.getCode() ,responseView.getMessage());
        this.iPage = iPage.setRecords(null);
    }

}
