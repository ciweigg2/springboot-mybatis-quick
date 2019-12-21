package com.mxc.springbootmybatisquick.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className BlListRequest
 * @description 查询列表请求参数
 * @date 2019/11/28 5:48 下午
 **/
@Data
public class BlListRequest implements Serializable {

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 统一社会信用代码
     */
    private String unIsCid;

    /**
     * 法定代表人
     */
    private String name;

    /**
     * 经办人
     */
    private String oper;

}
