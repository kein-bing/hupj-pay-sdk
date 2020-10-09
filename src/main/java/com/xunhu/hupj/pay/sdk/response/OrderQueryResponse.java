package com.xunhu.hupj.pay.sdk.response;

import lombok.Data;

@Data
public class OrderQueryResponse extends BaseResponse {
    /** 订单id */
    String order_id;
    /** 商户订单号 */
    String out_trade_no;
    /** 订单状态 */
    String status;
    /** 支付完成时间 */
    String time_end;
    /** 订单金额 */
    Integer total_fee;
    /** 附加数据 */
    String attach;
}
