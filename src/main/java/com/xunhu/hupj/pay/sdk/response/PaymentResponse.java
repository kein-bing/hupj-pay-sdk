package com.xunhu.hupj.pay.sdk.response;

import lombok.Data;

/**
 * @description: PaymentResult
 * @author: wuhb
 * @date: 2019/12/26
 */
@Data
public class PaymentResponse extends BaseResponse {

    /** 订单id */
    String order_id;
    /** 商户订单号 */
    String out_trade_no;
    /** 订单金额 */
    Integer total_fee;
    /** 二维码链接 */
    String code_url;
    /** prepare_id */
    String prepareId;
    /** H5支付返回的URL地址 */
    String mweb_url;
}
