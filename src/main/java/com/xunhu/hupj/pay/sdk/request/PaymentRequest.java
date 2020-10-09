package com.xunhu.hupj.pay.sdk.request;

import com.xunhu.hupj.pay.sdk.domain.ProfitSharingDetail;
import lombok.Data;

import java.util.List;

/**
 * 项目名称：hupj-pay-sdk
 * 类 名 称：PaymentRequest
 * 类 描 述：支付参数
 * 创建时间：2020-07-24 10:51
 * 创 建 人：louis
 */
@Data
public class PaymentRequest extends BaseRequest {
    /** 商户订单号，必填 */
    String out_trade_no;
    /** 商品描述  */
    String body;
    /** 商品详情 */
    String goods_detail;
    /** 总金额 */
    Integer total_fee;
    /** 回调地址 */
    String notify_url;
    /** 附加数据 */
    String attach;
    /** 支付类型（alipay:支付宝，wechat：微信） */
    String type;
    /** 交易方式（NATIVE:扫码付，JSAPI：仅针对微信的JSAPI支付；WAP：wap支付 */
    String trade_type;
    /** WAP网站URL地址 */
    String wap_url;
    /** WAP网站名 */
    String wap_name;
    /** 是否分账 */
    Boolean profit_sharing;
    /** 分账详情 */
    List<ProfitSharingDetail> profit_sharing_detail;
}
