package com.mxc.springbootmybatisquick.config;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maxiucheng
 * @className MybatisPlusPage
 * @description 封装mybatisplus分页
 * @date 2019/11/28 5:45 下午
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

    /**
     * 排序字段信息 [column 需要进行排序的字段] [asc 是否正序排列，默认 true]
     */
    private List<OrderItem> orders = new ArrayList<>();

}