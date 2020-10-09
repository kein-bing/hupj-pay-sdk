package com.xunhu.hupj.pay.sdk.response;

import lombok.Data;

/**
 * 订单退款返回参数
 *
 * @author wuhb
 */
@Data
public class OrderRefundResponse extends BaseResponse {
    /**
     * 平台退款单号
     */
    String refund_no;
    /**
     * 商户退款单号
     */
    String out_refund_no;
    /**
     * 平台交易订单号
     */
    String order_id;
}
