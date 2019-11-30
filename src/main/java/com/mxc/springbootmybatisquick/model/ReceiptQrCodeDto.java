package com.mxc.springbootmybatisquick.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className ReceiptQrCodeDto
 * @description 二维码回执接口返回参数
 * @date 2019/11/29 4:53 下午
 * @menu
 **/
@Data
public class ReceiptQrCodeDto implements Serializable {

    /**
     * 请求头
     */
    private MessageHeader message_header;

    /**
     * 请求内容
     */
    private MessageContent message_content;

    @Data
    public static class MessageHeader implements Serializable{

        /**
         * 签名值
         */
        private String sign;

        /**
         * 版本
         */
        private String version;

        /**
         * 错误码 0成功
         */
        private String errorCode = "0";

        /**
         * 错误信息
         */
        private String errorInfo;

    }

    @Data
    public static class MessageContent implements Serializable{

        /**
         * 二维码类型,1101 扫码登录和协同签名，1102 仅扫码登录
         */
        private String qrtype;

        /**
         * 二维码标识
         */
        private String qrid;

        /**
         * 响应时间
         */
        private String opertime;

    }

}
