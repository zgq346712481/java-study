/**
 * Copyright (C), 2005-2019, 北京优路教育股份有限公司
 * FileName: postRequest
 * Author:   admin
 * Date:     2019/9/29 14:14
 * Description: Java接口多线程并发测试:首先写一个接口post请求测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者           修改时间           版本号              描述
 */
package com.pancm.thread.jiekou;

/**
 * 〈自动化测试平台〉
 * 〈Java接口多线程并发测试:首先写一个接口post请求测试类〉
 * https://www.cnblogs.com/111testing/p/9572258.html
 *
 * @author admin
 * @create 2019/9/29
 * @since 1.0.0
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class postRequest {

    public static void postRequestTest(String para1, String para2, String para3) throws Exception {
        long begaintime = System.currentTimeMillis();//开始系统时间
        CloseableHttpClient httpclient = HttpClients.createDefault();


        String url = "https://www.baidu.com";
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Authorization", "Bearer  qwertyu12345678zxcvbnm");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("time", "11234567890");
        httpPost.setHeader("X-Accept-Locale", "zh_CN");

        //添加 body 参数
        String orderToken = "123456";
//        String para1;
//        String orderToken = postRequest1(para1);  //从上一个接口的返回数据里面获取参数
        String body = String.format("{\"Name\":\"%s\",\"age\":\"%s\",\"address\":\"%s\"}", para2, para3, orderToken);

        httpPost.setEntity(new StringEntity(body));

        //设置 params 参数-------------设置了body就不能再设置params
        //String params = "";
        //String charSet = "UTF-8";
        //StringEntity entity = new StringEntity(params, charSet);
        //httpPost.setEntity(entity);

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                System.out.println("TakegoOrder 接口请求成功");
                //return jsonString;
                System.out.println(jsonString);
                if (jsonString.contains("\"success\":true") && jsonString.contains("\"time\":\"2018")) {
                    System.out.println("成功查询！！！！");
                } else {
                    System.err.println("查询失败！！----" + body);
                }

            } else {
                System.err.println("请求返回:" + state + "(" + url + ")");
            }
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis(); //结束时间
            System.out.println("  接口请求耗时 ： " + (endTime - begaintime));
        }
        //return null;
    }
}