/**
 * 说明：Demo仅提供加签、验签和简单的接口调用参考
 * 具体的开发请以平台情况和接口文档为准
 * 
 *汇付天下有限公司
 *
 * Copyright (c) 2006-2013 ChinaPnR,Inc.All Rights Reserved.
 */
package com.huifu.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.huifu.util.httpClient.HttpClientHandler;

public class UserRegister {
    
    //如果关注性能问题可以考虑使用HttpClientConnectionManager
    public String doPost(Map<String, String> params) throws ClientProtocolException, IOException {
        String result = null;
        List<NameValuePair> nvps = HttpClientHandler.buildNameValuePair(params);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        EntityBuilder builder = EntityBuilder.create();
        try {
            HttpPost httpPost = new HttpPost(HttpClientHandler.HTTP_HOST);
            builder.setParameters(nvps);
            httpPost.setEntity(builder.build());
            CloseableHttpResponse response = httpclient.execute(httpPost);

            try {
                HttpEntity entity = response.getEntity();
                if (response.getStatusLine().getReasonPhrase().equals("OK")
                    && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result = EntityUtils.toString(entity, "UTF-8");
                }
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return result;
    }

    /**
     * 模拟开户接口请求参数
     * @throws Exception 
     * 
     */
    private Map<String, String> getParams() throws Exception {
        String version = "10";
        String cmdId = "UserRegister";
        String merCustId = "6000060000674426";// 商户客户号
        String bgRetUrl = "http://localhost:8080/p2p_trade_demo-JAVA/userRegister";
       // String bgRetUrl = "http://mertest.chinapnr.com/muser/publicRequests";
        String RetUrl = "http://localhost:8080/p2p_trade_demo-JAVA/userRegister";
        String UsrId = "jlhxy_201510161606";
        //String UsrName = "孙利阳";
        String UsrName =HttpClientHandler.getBase64Encode("孙利阳"); ;
        String IdType = "00";
        String IdNo = "210111198806264233";
        String UsrMp = "15313721756";
        String CharSet = "UTF-8";
        String UsrEmail = "3224500254@qq.com";
        // 若为中文，请用Base64转码
        String merPriv = HttpClientHandler.getBase64Encode("11");

        
        Map<String, String> params = new HashMap<String, String>();
        params.put("Version", version);
        params.put("CmdId", cmdId);
        params.put("MerCustId", merCustId);
        params.put("BgRetUrl", bgRetUrl);
        params.put("RetUrl", RetUrl);
        params.put("UsrId",UsrId);
        params.put("UsrName",UsrName);
        params.put("IdType",IdType);
        params.put("IdNo", IdNo);
        params.put("UsrMp", UsrMp);
        params.put("UsrEmail", UsrEmail);
        params.put("CharSet", CharSet);
        params.put("MerPriv", merPriv);

        // 组装加签字符串原文
        // 注意加签字符串的组装顺序参 请照接口文档
        StringBuffer buffer = new StringBuffer();
        buffer.append(StringUtils.trimToEmpty(version)).append(StringUtils.trimToEmpty(cmdId))
            .append(StringUtils.trimToEmpty(merCustId)).append(StringUtils.trimToEmpty(bgRetUrl))
            .append(StringUtils.trimToEmpty(RetUrl)).append(StringUtils.trimToEmpty(UsrId))
            .append(StringUtils.trimToEmpty(UsrName)).append(StringUtils.trimToEmpty(IdType))
            .append(StringUtils.trimToEmpty(IdNo)).append(StringUtils.trimToEmpty(UsrMp))
            .append(StringUtils.trimToEmpty(UsrEmail)).append(StringUtils.trimToEmpty(bgRetUrl))
            .append(StringUtils.trimToEmpty(merPriv));
        String plainStr = buffer.toString();
        System.out.println(plainStr);
        params.put("ChkValue", SignUtils.encryptByRSA(plainStr));

        return params;
    }

    /**
     * 模拟接口调用 - 放款
     * 根据接口文档使用post方式
     * @throws Exception 
     * 
     */
    public static void main(String[] args) throws Exception {
        UserRegister ts = new UserRegister();
        Map<String, String> params = ts.getParams();
        // 1. result 为同步返回的结果(jason格式)，可转换成对应的实体对象
        // 2. 注意：此返回结果中没有使用encode，所以不需要做decode处理
        // 3. 验证签名的方式与异步应答的验签相同，可参照异步应答接收的处理方式
        String result = ts.doPost(params);
        System.out.println(result);
    }
}
