package com.xunhu.hupj.pay.sdk.request;

import lombok.Data;

@Data
public class OrderRefundRequest extends BaseRequest {

    /** 虎皮椒平台订单id */
    String order_id;
    /** 商户订单号 */
    String out_trade_no;
    /** 商户退款单号 */
    String out_refund_no;
    /** 退款金额 */
    Integer refund_fee;
    /** 退款原因 */
    String refund_desc;
    /** 通知回调地址 */
    String notify_url;
}
