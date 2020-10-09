package com.xunhu.hupj.pay.sdk.utils;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 项目名称：hupj-pay-sdk
 * 类 名 称：SignUtils
 * 类 描 述：签名工具类
 * 创建时间：2020-07-24 10:30
 * 创 建 人：wuhb
 */
public class SignUtil {

    static final String FIELD_SIGN="sign";

    /**
     * 签名请求参数
     * @param data  签名参数对象：key：参数名；value：参数值
     * @param key   商户密钥
     * @return      签名字符串
     * @throws Exception
     */
    public static String generateSignature(Map<String, String> data, String key) {
        // 对参数根据参数名进行排序
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals(FIELD_SIGN)) {
                // 排除sign字段
                continue;
            }
            if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
        }

        // 添加商户密钥
        sb.append("key=").append(key);

        return MD5(sb.toString()).toUpperCase();

    }

    /**
     * 签名请求参数
     * @param obj   待签名的对象
     * @param key   商户密钥
     * @return      签名字符串
     */
    public static String generateSignature(Object obj,String key){
        String signString= BeanUtil.objectToSignString(obj);
        String sign = SignUtil.generateSignature(signString,key);

        return sign;
    }

    /**
     * 签名请求参数
     * @param message       待签名的字符串
     * @param key           商户密钥
     * @return              签名字符串
     */
    public static String generateSignature(String message, String key) {
        // 添加商户密钥
        message +="key=" + key;

        return MD5(message).toUpperCase();
    }

    /**
     * 签名校验
     * @param obj       待校验的数据对象，需包含sign
     * @param key       商户密钥
     */
    public static void signVerification(Object obj,String key){
        Map<String,String> map=BeanUtil.objectToMap(obj);

        String sign=generateSignature(obj,key);

        if(!map.containsKey(FIELD_SIGN)){
            throw new RuntimeException("不存在签名数据");
        }

        if(!sign.equals(map.get(FIELD_SIGN))){
            throw new RuntimeException("签名校验失败");
        }

    }

        /**
         * 对字符串数据进行MD5码生成
         * @param data
         * @return MD5码
         * @throws Exception
         */
    public static String MD5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        }catch (Exception e){
            throw new RuntimeException("MD5生成异常"+ e.getMessage());
        }
    }
}
