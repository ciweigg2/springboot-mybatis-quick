package com.mxc.springbootmybatisquick.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mxc.springbootmybatisquick.config.MyIPage;
import com.mxc.springbootmybatisquick.model.mapstruct.MyIPageMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 通用返回包装
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
public class ResponseView<T> implements Serializable {

    /**
     * 是否正确返回
     */
    private boolean success;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回结果
     */
    private T result;

    /**
     * 拼装输出View的MAP对象
     *
     * @param result  结果
     * @param success 是否成功
     * @param code    状态码
     * @param message 信息
     */
    public ResponseView(T result, boolean success, int code, String message) {
        this.result = result;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 返回success为true的map对象
     *
     * @param result 响应map对象
     * @return 返回success为true的对象
     */
    public static ResponseView success(Object result) {
        return new ResponseView(result, Boolean.TRUE, 200, "");
    }

    /**
     * @param message 消息
     * @return 返回success为false的结果
     */
    public static ResponseView fail(String message) {
        return new ResponseView((Object) null, Boolean.FALSE, 200, message);
    }

    /**
     * @param message 消息
     * @return 返回success为false的结果
     */
    public static ResponseView fail(Object result, String message) {
        return new ResponseView(result, Boolean.FALSE, 200, message);
    }

    /**
     * @param message 消息
     * @return 返回success为false的结果
     */
    public static ResponseView fail(Integer code, String message) {
        return new ResponseView(null, Boolean.FALSE, code, message);
    }

    /***
     * 绑定分页信息
     * @param page
     */
    public ResponseView bindPagination(Page page) {
        MyIPage myIPage = MyIPageMapper.INSTANCE.pageToMyIPage(page);
        myIPage.setRecords((List)result);
        return new ResponseView(myIPage, success, code, message);
    }

}
