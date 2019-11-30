package com.mxc.springbootmybatisquick.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author maxiucheng
 * @className ReceiptQrCodeProperties
 * @description 二维码回执接口参数
 * @date 2019/11/29 4:19 下午
 * @menu
 **/
@Data
public class ReceiptQrCodeRequest implements Serializable {

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
         * 业务类型
         */
        private String businesstype;

        /**
         * 系统代码
         */
        private String syscode;

        /**
         * 系统授权码
         */
        private String authcode;

        /**
         * 签名值
         */
        private String sign;

        /**
         * 版本
         */
        private String version;

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
         * 移动端用户唯一标识
         */
        private String tragerSn;

        /**
         * 企业名称
         */
        private String entname;

        /**
         * 电子营业执照序列号
         */
        private String licencesn;

        /**
         * 二维码内容类型:0-不包含小程序后台域名，1-包含小 程序后台域名
         */
        private String qrinfotype;

        /**
         * 返回数据类型，0 不包含图片，1 包含二维码图片
         */
        private String rettype;

        /**
         * 请求时间
         */
        private String opertime;

        /**
         * 登记日期
         */
        private String apprdate;

        /**
         * 授权事项
         */
        private String auth_content;

        /**
         * 授权人姓名
         */
        private String auth_name;

        /**
         * 授权书截止日期
         */
        private String auth_term;

        /**
         * 办事人执照唯一标识
         */
        private String auth_uniqueid;

        /**
         * 住所
         */
        private String dom;

        /**
         * 签名实体
         */
        private String entity;

        /**
         * 照面上的企业类型
         */
        private String enttype_cn;

        /**
         * 成立日期
         */
        private String estdate;

        /**
         * 电子营业执照文件 URL
         */
        private String imageurl;

        /**
         * 电子营业执照实体
         */
        private String licenceentity;

        /**
         * 法定代表人
         */
        private String name;

        /**
         * 授权人姓名
         */
        private String oper;

        /**
         * 授权结果
         */
        private String operflag;

        /**
         * 授权身份类型，0-法人，1-证照管理员，2-办事人
         */
        private String opertype;

        /**
         * 经营(驻在)期限自
         */
        private String opfrom;

        /**
         * 经营范围/业务范围
         */
        private String opscope;

        /**
         * 经营(驻在)期限至
         */
        private String opto;

        /**
         * 注册资本
         */
        private String regcap;

        /**
         * 登记机关
         */
        private String regorg_cn;

        /**
         * 企业类型，1-企业，8-个体工商户
         */
        private String type;

        /**
         * 统一社会信用代码
         */
        private String uniscid;

    }

}
