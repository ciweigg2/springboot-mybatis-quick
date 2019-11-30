package com.mxc.springbootmybatisquick.utils;

import lombok.Getter;

/**
 * @author maxiucheng
 * @className EnumExceptionMessageWebMvc
 * @description 异常处理枚举
 * @date 2019/11/30 11:05 上午
 * @menu
 **/
@Getter
public enum EnumExceptionMessageWebMvc {

    // 非预期异常
    UNEXPECTED_ERROR("服务发生非预期异常，请联系管理员！"),
    PARAM_VALIDATED_UN_PASS("参数校验(JSR303)不通过，请检查参数或联系管理员！"),
    NO_HANDLER_FOUND_ERROR("404未找到对应的处理器，请检查 API 或联系管理员！"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_ERROR("不支持的请求方法，请检查 API 或联系管理员！"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_ERROR("不支持的互联网媒体类型，请检查 API 或联系管理员");

    private final String message;

    EnumExceptionMessageWebMvc(String message) {
        this.message = message;
    }

}
