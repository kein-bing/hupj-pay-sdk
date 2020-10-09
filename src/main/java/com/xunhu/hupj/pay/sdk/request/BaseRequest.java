package com.xunhu.hupj.pay.sdk.request;


import lombok.Data;

/**
 * 请求参数基类
 *
 * @author wuhb
 */
@Data
public class BaseRequest {
    /**
     * 商户id
     */
    String mchid;
    /**
     * 随机字符串
     */
    String nonce_str;
    /**
     * 签名
     */
    String sign;
    /**
     * 接口版本
     */
    String version;
}
