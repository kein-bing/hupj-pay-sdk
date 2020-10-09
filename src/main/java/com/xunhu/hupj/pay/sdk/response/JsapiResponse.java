package com.xunhu.hupj.pay.sdk.response;

import lombok.Data;

@Data
public class JsapiResponse extends BaseResponse {
    /** 平台订单id */
    String order_id;
    /** 订单金额 */
    Integer total_fee;
    /** 商户名称 */
    String merchantName;
    /** 用于发起支付的支付参数 */
    String jsapi;
}
