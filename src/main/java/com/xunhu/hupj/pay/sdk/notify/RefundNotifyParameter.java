package com.xunhu.hupj.pay.sdk.notify;

import lombok.Data;

/**
 * 退款通知回调参数
 *
 * @author wuhb
 */
@Data
public class RefundNotifyParameter {
    /**
     * 商户id
     */
    String mchid;
    /**
     * 随机字符串
     */
    String nonce_str;
    /**
     * 签名字符串
     */
    String sign;
    /**
     * 退款单id
     */
    String refund_id;
    /**
     * 商户退款单号
     */
    String out_refund_id;
    /**
     * 退款状态
     */
    String refund_status;
    /**
     * 退款金额
     */
    String refund_fee;
    /**
     * 交易订单ID
     */
    String order_id;
    /**
     * 商户交易订单号
     */
    String out_trade_no;
    /**
     * 退款成功时间
     */
    String refund_time;
    /**
     * 订单总金额
     */
    Integer total_fee;
}
