package com.xunhu.hupj.pay.sdk.request;

import com.xunhu.hupj.pay.sdk.domain.ProfitSharingDetail;
import lombok.Data;

import java.util.List;

/**
 * JSAPI请求参数
 *
 * @author wuhb
 */
@Data
public class JsapiRequest extends BaseRequest {
    /**
     * 渠道id
     */
    String channel_id;
    /**
     * openid
     */
    String openid;
    /**
     * 描述
     */
    String body;
    /**
     * 商品详情
     */
    String goods_detail;
    /**
     * 总金额
     */
    Integer total_fee;
    /**
     * 附加数据
     */
    String attach;
    /**
     * 成功后的跳转地址
     */
    String redirect_url;
    /**
     * 回调地址
     */
    String notify_url;
    /**
     * 客户订单号
     */
    String out_trade_no;
    /**
     * 是否分账
     */
    Boolean profit_sharing;
    /**
     * 分账详情
     */
    List<ProfitSharingDetail> profit_sharing_detail;
}
