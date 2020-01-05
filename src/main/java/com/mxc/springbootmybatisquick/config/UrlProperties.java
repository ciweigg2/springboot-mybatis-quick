package com.mxc.springbootmybatisquick.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

import static com.mxc.springbootmybatisquick.config.UrlProperties.THIRD_PARTY_URL;

/**
 * @author maxiucheng
 * @className UrlProperties
 * @description 第三方请求接口通用url封装
 * @date 2019/11/29 3:23 下午
 **/
@Data
@ConfigurationProperties(prefix = THIRD_PARTY_URL)
public class UrlProperties implements Serializable {

    public static final String THIRD_PARTY_URL = "third.party.url";

    /**
     * 获取业务请求唯一标识(原获取二维码接口)请求地址
     */
    private String getQrCodeUrl;

}
