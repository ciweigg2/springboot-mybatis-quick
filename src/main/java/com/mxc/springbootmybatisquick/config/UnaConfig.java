package com.mxc.springbootmybatisquick.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import static com.mxc.springbootmybatisquick.config.UnaConfig.PREFIX;

/**
 * @author Una Ma
 * @className MinBoxConfig
 * @description 使用@ConstructorBinding注解后绑定了构造函数无需set
 * @date 2020/1/5 4:23 下午
 * @menu
 **/
@ConfigurationProperties(prefix = PREFIX)
@ConstructorBinding
@Getter
public class UnaConfig {
    /**
     * 映射绑定 "minbox.config"前缀的配置信息
     */
    public static final String PREFIX = "una.config";
    /**
     * 配置信息：作者
     */
    private String author;
    /**
     * 配置信息：博客地址
     */
    private String blogAddress;

    public UnaConfig(String author, String blogAddress) {
        this.author = author;
        this.blogAddress = blogAddress;
    }

}
