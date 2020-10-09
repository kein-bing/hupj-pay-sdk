package com.xunhu.hupj.pay.sdk;

import com.xunhu.hupj.pay.sdk.request.JsapiRequest;
import com.xunhu.hupj.pay.sdk.request.OrderQueryRequest;
import com.xunhu.hupj.pay.sdk.request.OrderRefundRequest;
import com.xunhu.hupj.pay.sdk.request.PaymentRequest;
import com.xunhu.hupj.pay.sdk.response.JsapiResponse;
import com.xunhu.hupj.pay.sdk.response.OrderQueryResponse;
import com.xunhu.hupj.pay.sdk.response.OrderRefundResponse;
import com.xunhu.hupj.pay.sdk.response.PaymentResponse;

/**
 * 迅虎支付客户端接口
 *
 * @author wuhb
 */
public interface XunhuPayClient {

    /**
     * 发起Native支付
     * @param request   支付请求参数
     * @return  支付返回参数
     */
    PaymentResponse payWithNative(PaymentRequest request);

    /**
     * 发起H5支付
     *
     * @param request   H5支付请求参数
     * @return  支付返回参数
     */
    PaymentResponse payWithH5(PaymentRequest request);

    /**
     * 发起JSAPI请求
     *
     * @param request   JSAPI请求参数
     * @return  JSAPI返回参数
     */
    JsapiResponse payWithJsapi(JsapiRequest request);

    /**
     * 查询订单信息
     *
     * @param request   订单查询参数
     * @return  订单查询返回值
     */
    OrderQueryResponse query(OrderQueryRequest request);

    /**
     * 发起订单退款请求
     *
     * @param request   退款请求参数
     * @return  订单退款返回参数
     */
    OrderRefundResponse refund(OrderRefundRequest request);
}
