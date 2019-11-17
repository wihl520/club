package com.gzqf.club.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>Description: </p>
 * HttpClient工具类
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 16:20
 **/
public class HttpClientUtils {
    /**
     * 创建一个get请求
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        String result = "";
        try {
            // 创建一个httpClient对象
            HttpClient httpClient = HttpClients.createDefault();
            // 创建一个HTTPResponse对象（用来获取响应结果）
            HttpResponse httpResponse = null;
            // 创建一个HTTPGet对象,参数为对应的URL地址
            HttpGet httpGet = new HttpGet(url);
            // 设置头
            httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.62 Safari/537.36");
            // 执行访问
            httpResponse = httpClient.execute(httpGet);
            // 获取响应结果
            HttpEntity entity = httpResponse.getEntity();
            // 将结果转成String对象
            result = EntityUtils.toString(entity);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 创建一个post请求
     *
     * @param url
     * @param params
     * @return String
     */
    public static String post(String url, Map<String, String> params) {
        String result = "";
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpResponse httpResponse;
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("user-agent", "");
            ArrayList<BasicNameValuePair> list = new ArrayList<>();
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                BasicNameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
                list.add(pair);
            }
            // 设置参数到httpPost对象里面
            httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
            // 执行访问
            httpResponse = httpClient.execute(httpPost);
            // 获取HTTPEntity
            HttpEntity httpEntity = httpResponse.getEntity();
            // 将HTTPResponse转成String
            result = EntityUtils.toString(httpEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
