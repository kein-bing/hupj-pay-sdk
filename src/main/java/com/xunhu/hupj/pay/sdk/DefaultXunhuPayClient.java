package com.xunhu.hupj.pay.sdk;

import com.alibaba.fastjson.JSONObject;
import com.xunhu.hupj.pay.sdk.request.*;
import com.xunhu.hupj.pay.sdk.response.JsapiResponse;
import com.xunhu.hupj.pay.sdk.response.OrderQueryResponse;
import com.xunhu.hupj.pay.sdk.response.OrderRefundResponse;
import com.xunhu.hupj.pay.sdk.response.PaymentResponse;
import com.xunhu.hupj.pay.sdk.utils.HttpUtil;
import com.xunhu.hupj.pay.sdk.utils.SignUtil;

/**
 * 迅虎支付客户端
 *
 * @author wuhb
 */
public class DefaultXunhuPayClient implements XunhuPayClient {
    private String secretKey;
    private String domain;

    public DefaultXunhuPayClient(String secretKey, String domain) {
        this.secretKey = secretKey;
        this.domain = domain;
    }

    public DefaultXunhuPayClient(String secretKey) {
        this.secretKey = secretKey;
        this.domain = XunhuPayConstants.DOMAIN;
    }

    @Override
    public PaymentResponse payWithNative(PaymentRequest request) {
        handleParameter(request);

        String url = domain + XunhuPayConstants.URL_SUFFIX_PAYMENT;

        String strResponse = HttpUtil.httpPostWithJson(url, JSONObject.toJSONString(request));

        // 处理返回数据
        PaymentResponse response = JSONObject.parseObject(strResponse, PaymentResponse.class);

        if (!response.getReturn_code().equals("SUCCESS")) {
            throw new RuntimeException(response.getErr_code() + ":" + response.getErr_msg());
        }

        return response;
    }

    @Override
    public PaymentResponse payWithH5(PaymentRequest request) {
        handleParameter(request);

        String url = domain + XunhuPayConstants.URL_SUFFIX_PAYMENT;

        String strResponse = HttpUtil.httpPostWithJson(url, JSONObject.toJSONString(request));

        // 处理返回数据
        PaymentResponse response = JSONObject.parseObject(strResponse, PaymentResponse.class);

        if (!response.getReturn_code().equals("SUCCESS")) {
            throw new RuntimeException(response.getErr_code() + ":" + response.getErr_msg());
        }

        return response;
    }

    @Override
    public JsapiResponse payWithJsapi(JsapiRequest request) {
        handleParameter(request);

        String url = domain + XunhuPayConstants.URL_SUFFIX_JSAPI;

        String strResponse = HttpUtil.httpPostWithJson(url, JSONObject.toJSONString(request));

        // 处理返回数据
        JsapiResponse response = JSONObject.parseObject(strResponse, JsapiResponse.class);

        if (!response.getReturn_code().equals("SUCCESS")) {
            throw new RuntimeException(response.getErr_code() + ":" + response.getErr_msg());
        }

        return response;
    }

    @Override
    public OrderQueryResponse query(OrderQueryRequest request) {

        handleParameter(request);

        String url = domain + XunhuPayConstants.URL_SUFFIX_QUERY;

        String strResponse = HttpUtil.httpPostWithJson(url, JSONObject.toJSONString(request));

        // 处理返回数据
        OrderQueryResponse response = JSONObject.parseObject(strResponse, OrderQueryResponse.class);

        if (!response.getReturn_code().equals("SUCCESS")) {
            throw new RuntimeException(response.getErr_code() + ":" + response.getErr_msg());
        }

        return response;
    }

    @Override
    public OrderRefundResponse refund(OrderRefundRequest request) {
        handleParameter(request);

        String url = domain + XunhuPayConstants.URL_SUFFIX_REFUND;

        String strResponse = HttpUtil.httpPostWithJson(url, JSONObject.toJSONString(request));

        // 处理返回数据
        OrderRefundResponse response = JSONObject.parseObject(strResponse, OrderRefundResponse.class);

        if (!response.getReturn_code().equals("SUCCESS")) {
            throw new RuntimeException(response.getErr_code() + ":" + response.getErr_msg());
        }

        return response;
    }

    private void handleParameter(BaseRequest request) {
        // 参数校验
        request.setNonce_str(System.currentTimeMillis() + "");
        String sign = SignUtil.generateSignature(request, secretKey);
        request.setSign(sign);
    }

}
