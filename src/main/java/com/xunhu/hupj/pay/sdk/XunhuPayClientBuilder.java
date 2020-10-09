package com.xunhu.hupj.pay.sdk;

/**
 * 项目名称：hupj
 * 类 名 称：XunhuPayClientBuilder
 * 类 描 述：TODO
 * 创建时间：2020-08-03 23:25
 * 创 建 人：louis
 */
public class XunhuPayClientBuilder {
    public static XunhuPayClient create(String secretKey) {
        return new DefaultXunhuPayClient(secretKey);
    }

    public static XunhuPayClient create(String secretKey, String domain) {
        return new DefaultXunhuPayClient(secretKey, domain);
    }

}
