package com.mxc.springbootmybatisquick.model;

import com.diboot.core.binding.annotation.BindDict;
import lombok.Data;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className BusinessLicenseVo
 * @description 测试不继承自定义字典获取值
 * @date 2019/12/19 4:18 下午
 * @menu
 **/
@Data
public class BusinessLicenseVO implements Serializable {

    /**
     * 统一社会信用代码名称
     */
    @BindDict(type="CODE", field = "unIsCid")
    private String unIsCidName;

    /**
     * 统一社会信用代码
     */
    private String unIsCid;

}
