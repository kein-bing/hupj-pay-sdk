package com.xunhu.hupj.pay.sdk.notify;

import lombok.Data;

/**
 * 项目名称：hupj
 * 类 名 称：RefundNotifyParameter
 * 类 描 述：TODO
 * 创建时间：2020-08-03 23:35
 * 创 建 人：louis
 */
@Data
public class RefundNotifyParameter {
    /** 商户id */
    String mchid;
    /** 随机字符串 */
    String nonce_str;
    /** 签名字符串 */
    String sign;
    /** 退款单id */
    String refund_id;
    /** 商户退款单号 */
    String out_refund_id;
    /** 退款状态 */
    String refund_status;
    /** 退款金额 */
    String refund_fee;
    /** 交易订单ID */
    String order_id;
    /** 商户交易订单号 */
    String out_trade_no;
    /** 退款成功时间 */
    String refund_time;
    /** 订单总金额 */
    Integer total_fee;
}
