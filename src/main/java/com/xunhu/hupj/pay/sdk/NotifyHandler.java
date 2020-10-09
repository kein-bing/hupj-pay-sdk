package com.xunhu.hupj.pay.sdk;

import com.alibaba.fastjson.JSONObject;
import com.xunhu.hupj.pay.sdk.notify.OrderNotifyParameter;
import com.xunhu.hupj.pay.sdk.notify.RefundNotifyParameter;
import com.xunhu.hupj.pay.sdk.utils.SignUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 项目名称：hupj
 * 类 名 称：NotifyHandler
 * 类 描 述：订单支付成功回调通知处理工具类
 * 创建时间：2020-08-03 23:08
 * 创 建 人：louis
 */
public class NotifyHandler {

    /**
     * 处理订单支付成功回调通知（request中body参数仅可读取一次，重复读取将抛出异常）
     * @param request           请求request
     * @param secretKey         商户密钥
     * @return
     */
    public static OrderNotifyParameter handleOrderNotify(HttpServletRequest request,String secretKey) {
        // 获取请求body数据
        String body = readBodyFromRequest(request);

        JSONObject jsonRequest=JSONObject.parseObject(body);

        SignUtil.signVerification(jsonRequest,secretKey);

        OrderNotifyParameter parameter= JSONObject.parseObject(body,OrderNotifyParameter.class);

        return parameter;
    }


    /**
     * 处理订单支付成功回调通知
     * @param parameter         订单通知请求参数
     * @param secretKey         商户密钥
     * @return
     */
    public static OrderNotifyParameter handleOrderNotify(OrderNotifyParameter parameter,String secretKey) {
        // 签名校验
        SignUtil.signVerification(parameter,secretKey);

        return parameter;
    }

    /**
     * 处理退款成功回调通知（request中body参数仅可读取一次，重复读取将抛出异常）
     * @param request           请求request
     * @param secretKey         商户密钥
     * @return
     */
    public static RefundNotifyParameter handleRefundNotify(HttpServletRequest request, String secretKey) {
        String body = readBodyFromRequest(request);

        JSONObject jsonRequest=JSONObject.parseObject(body);

        SignUtil.signVerification(jsonRequest,secretKey);

        RefundNotifyParameter parameter= JSONObject.parseObject(body,RefundNotifyParameter.class);

        return parameter;
    }


    /**
     * 处理退款成功回调通知
     * @param parameter         订单通知请求参数
     * @param secretKey         商户密钥
     * @return
     */
    public static RefundNotifyParameter handleRefundNotify(RefundNotifyParameter parameter,String secretKey) {
        // 签名校验
        SignUtil.signVerification(parameter,secretKey);

        return parameter;
    }



    private static String readBodyFromRequest(HttpServletRequest request)
    {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
