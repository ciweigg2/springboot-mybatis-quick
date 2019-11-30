package com.mxc.springbootmybatisquick.model.mapstruct;

import com.mxc.springbootmybatisquick.model.ReceiptQrCodeDto;
import com.mxc.springbootmybatisquick.model.ReceiptQrCodeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author maxiucheng
 * @className ThirdPartyMapper
 * @description 二维码回执接口参数映射
 * @date 2019/11/29 5:01 下午
 * @menu
 **/
@Mapper(componentModel = "spring")
public interface ThirdPartyMapper {

    @Mappings({
            @Mapping(source = "receiptQrCodeRequest.message_header.sign" ,target = "message_header.sign"),
            @Mapping(source = "receiptQrCodeRequest.message_header.version" ,target = "message_header.version"),
            @Mapping(source = "receiptQrCodeRequest.message_content.qrtype" ,target = "message_content.qrtype"),
            @Mapping(source = "receiptQrCodeRequest.message_content.qrid" ,target = "message_content.qrid"),
            @Mapping(source = "receiptQrCodeRequest.message_content.opertime" ,target = "message_content.opertime")
    })
    ReceiptQrCodeDto receiptQrCodeRequestToReceiptQrCodeDto(ReceiptQrCodeRequest receiptQrCodeRequest, ReceiptQrCodeDto receiptQrCodeDto);

}
