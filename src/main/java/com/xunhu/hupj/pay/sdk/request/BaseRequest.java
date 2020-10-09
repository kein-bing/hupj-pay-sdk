package com.xunhu.hupj.pay.sdk.request;


import lombok.Data;

/**
 * 项目名称：hupj-pay-sdk
 * 类 名 称：BaseRequest
 * 类 描 述：请求参数基类
 * 创建时间：2020-07-24 10:46
 * 创 建 人：louis
 */
@Data
public class BaseRequest {
    /** 商户id */
    String mchid;
    /** 随机字符串 */
    String nonce_str;
    /** 签名 */
    String sign;
    /** 接口版本 */
    String version;
}
