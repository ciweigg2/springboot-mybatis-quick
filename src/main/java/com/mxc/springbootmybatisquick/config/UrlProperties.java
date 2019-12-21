package com.mxc.springbootmybatisquick.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className UrlProperties
 * @description 第三方请求接口通用url封装
 * @date 2019/11/29 3:23 下午
 **/
@Data
@ConfigurationProperties(prefix = "third.party.url")
@Component
public class UrlProperties implements Serializable {

    /**
     * 获取业务请求唯一标识(原获取二维码接口)请求地址
     */
    private String getQrCodeUrl;

}
