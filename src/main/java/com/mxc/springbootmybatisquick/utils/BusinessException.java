package com.mxc.springbootmybatisquick.utils;

import lombok.Data;

/**
 * @author maxiucheng
 * @className ExtensionException
 * @description 业务异常封装
 * @date 2019/11/30 11:38 上午
 * @menu
 **/
@Data
public class BusinessException extends RuntimeException {

    /**
     * 业务异常码 200成功 500失败
     */
    private int code = 200;

    /**
     * 业务异常信息
     *
     */
    private String message;

    /**
     * 业务异常封装 错误码和错误信息
     *
     * @param code 异常码
     * @param message 错误信息
     */
    public BusinessException(int code ,String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 业务异常封装 错误信息
     *
     * @param message
     */
    public BusinessException(String message) {
        this.message = message;
    }

}
