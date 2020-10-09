package com.xunhu.hupj.pay.sdk.request;


import lombok.Data;

/**
 * 订单查询请求参数
 *
 * @author wuhb
 */
@Data
public class OrderQueryRequest extends BaseRequest {
    /**
     * 商户订单号
     */
    String out_trade_no;
    /**
     * 订单id
     */
    String order_id;

}
