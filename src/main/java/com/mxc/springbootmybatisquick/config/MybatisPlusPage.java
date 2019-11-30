package com.mxc.springbootmybatisquick.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className MybatisPlusPage
 * @description
 * @date 2019/11/28 5:45 下午
 * @menu 封装mybatisplus分页
 **/
@Data
public class MybatisPlusPage<T> implements Serializable {

    /**
     * 对象
     */
    private T object;

    /**
     * 每页条数
     */
    private long size;

    /**
     * 当前页数
     */
    private long current;

}