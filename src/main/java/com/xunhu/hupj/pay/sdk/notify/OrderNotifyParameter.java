package com.xunhu.hupj.pay.sdk.notify;

import lombok.Data;

/**
 * 项目名称：hupj
 * 类 名 称：OrderNotifyParameter
 * 类 描 述：TODO
 * 创建时间：2020-08-03 23:05
 * 创 建 人：louis
 */
@Data
public class OrderNotifyParameter {
    /** 商户id */
    String mchid;
    /** 随机字符串 */
    String nonce_str;
    /** 签名字符串 */
    String sign;
    /** 订单ID */
    String order_id;
    /** 商户订单号 */
    String out_trade_no;
    /** 官方交易号 */
    String transaction_id;
    /** 订单状态 */
    String status;
    /** 支付完成时间 */
    String time_end;
    /** 订单金额 */
    Integer total_fee;
    /** 附加数据 */
    String attach;
}
