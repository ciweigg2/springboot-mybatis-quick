package com.mxc.springbootmybatisquick.handler;

import com.mxc.springbootmybatisquick.utils.BusinessException;
import com.mxc.springbootmybatisquick.utils.EnumExceptionMessageWebMvc;
import com.mxc.springbootmybatisquick.utils.ResponseView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * @author 马秀成
 * @date 2019/10/28
 * @jdk.version 1.8
 * @desc 全局异常处理
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 针对业务异常的处理
     *
     * @param exception 业务异常
     * @param request   http request
     * @return 异常处理结果
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseView extensionException(BusinessException exception, HttpServletRequest request) {
        log.warn("请求发生了预期异常，出错的 url [{}]，出错的描述为 [{}]",
                request.getRequestURL().toString(), exception.getMessage());
        return ResponseView.fail(exception.getMessage());
    }

    /**
     * 空指针异常
     *
     * @param exception 异常信息
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseView nullPointerErrorHandler(Exception exception) {
        exception.printStackTrace();
        return ResponseView.fail("空指针异常");
    }

    /**
     * 针对spring web 中的异常的处理
     *
     * @param exception Spring Web 异常
     * @param request   http request
     * @return 异常处理结果
     */
    @ExceptionHandler(value = {
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class
    })
    public ResponseView springWebExceptionHandler(Exception exception, HttpServletRequest request) {
        log.error(MessageFormat.format("请求发生了非预期异常，出错的 url [{0}]，出错的描述为 [{1}]",
                request.getRequestURL().toString(), exception.getMessage()), exception);
        if (exception instanceof NoHandlerFoundException) {
            return ResponseView.fail(EnumExceptionMessageWebMvc.NO_HANDLER_FOUND_ERROR.getMessage());
        } else if (exception instanceof HttpRequestMethodNotSupportedException) {
            return ResponseView.fail(EnumExceptionMessageWebMvc.HTTP_REQUEST_METHOD_NOT_SUPPORTED_ERROR.getMessage());
        } else if (exception instanceof HttpMediaTypeNotSupportedException) {
            return ResponseView.fail(EnumExceptionMessageWebMvc.HTTP_MEDIA_TYPE_NOT_SUPPORTED_ERROR.getMessage());
        } else {
            return ResponseView.fail(EnumExceptionMessageWebMvc.UNEXPECTED_ERROR.getMessage());
        }
    }

    /**
     * 针对全局异常的处理
     *
     * @param exception 全局异常
     * @param request   http request
     * @return 异常处理结果
     */
    @ExceptionHandler(value = Throwable.class)
    public ResponseView throwableHandler(Exception exception, HttpServletRequest request) {
        log.error(MessageFormat.format("请求发生了非预期异常，出错的 url [{0}]，出错的描述为 [{1}]",
                request.getRequestURL().toString(), exception.getMessage()), exception);
        return ResponseView.fail(exception.getMessage());
    }

}
