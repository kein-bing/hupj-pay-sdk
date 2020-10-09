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
 * 项目名称：hupj-pay-sdk
 * 类 名 称：HupjPayClient
 * 类 描 述：迅虎支付客户端接口
 * 创建时间：2020-07-24 11:00
 * 创 建 人：louis
 */
public interface XunhuPayClient {

    PaymentResponse payWithNative(PaymentRequest request);

    PaymentResponse payWithH5(PaymentRequest request);

    JsapiResponse payWithJsapi(JsapiRequest request);

    OrderQueryResponse query(OrderQueryRequest request);

    OrderRefundResponse refund(OrderRefundRequest request);
}
