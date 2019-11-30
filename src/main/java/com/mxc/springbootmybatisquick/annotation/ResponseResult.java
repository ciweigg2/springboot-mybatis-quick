package com.mxc.springbootmybatisquick.annotation;

import java.lang.annotation.*;

/**
 * @author maxiucheng
 * @className ResponseResult
 * @description 统一返回格式封装
 * @date 2019/11/29 5:59 下午
 * @menu
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE ,ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
