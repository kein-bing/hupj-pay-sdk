package com.xunhu.hupj.pay.sdk.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * Http请求工具类
 *
 * @author wuhb
 */
public class HttpUtil {

    private static PoolingHttpClientConnectionManager pool;
    private static RequestConfig requestConfig;

    private static int timeout = 10000;


    static {
        Registry<ConnectionSocketFactory> socketFactoryRegistry =
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register(
                                "http", PlainConnectionSocketFactory.getSocketFactory()).register(
                        "https", SSLConnectionSocketFactory.getSocketFactory()).build();

        pool = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        pool.setMaxTotal(200);
        pool.setDefaultMaxPerRoute(2);

        requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .setConnectTimeout(timeout).build();


    }

    public static String httpPost(String url, String param) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setConfig(requestConfig);

        StringEntity stringEntity = new StringEntity(param, "UTF-8");
        httpPost.setEntity(stringEntity);

        return sendHttpPost(httpPost);
    }


    public static String httpPostWithJson(String httpUrl, String jsonParam) {

        HttpPost httpPost = new HttpPost(httpUrl);

        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("User-Agent", "HupjSDK/1.0");

        httpPost.setConfig(requestConfig);

        StringEntity stringEntity = new StringEntity(jsonParam, "UTF-8");
        httpPost.setEntity(stringEntity);

        return sendHttpPost(httpPost);
    }

    public static String httpGet(String httpUrl) {
        HttpGet httpGet = new HttpGet(httpUrl);
        httpGet.setConfig(requestConfig);
        return sendHttpGet(httpGet);
    }

    public static String sendHttpPost(HttpPost httpPost) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseContent = null;

        try {
            httpClient = getHttpClient();
            httpPost.setConfig(requestConfig);

            response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                responseContent = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            } else {
                responseContent = response.getStatusLine().getStatusCode() + " " +
                        response.getStatusLine().getReasonPhrase();
                throw new RuntimeException(responseContent);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return responseContent;
    }

    public static String sendHttpGet(HttpGet httpGet) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseContent = null;

        try {
            httpClient = getHttpClient();
            httpGet.setConfig(requestConfig);

            response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                responseContent = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return responseContent;
    }

    public static CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                // 设置连接池管理
                .setConnectionManager(pool)
                // 设置请求配置
                .setDefaultRequestConfig(requestConfig)
                // 设置重试次数
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();

        return httpClient;
    }
}
