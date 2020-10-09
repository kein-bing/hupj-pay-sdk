package com.xunhu.hupj.pay.sdk.response;

import lombok.Data;

/**
 * 请求返回参数基类
 *
 * @author wuhb
 */
@Data
public class BaseResponse {
    /**
     * 平台商户id
     */
    String mchid;
    /**
     * 返回码
     */
    String return_code;
    /**
     * 返回码信息
     */
    String return_msg;
    /**
     * 错误码
     */
    String err_code;
    /**
     * 错误信息描述
     */
    String err_msg;
    /**
     * 随机字符串
     */
    String nonce_str;
    /**
     * 签名
     */
    String sign;
}
