package com.huifu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huifu.util.SignUtils;
import com.huifu.util.httpClient.HttpClientHandler;

public class PayServlet extends HttpServlet {
    private static final long serialVersionUID = -1969188938538316979L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    	
    	   String version = "10";
           String cmdId = "UserRegister";
           String merCustId = "6000060000674426";// 商户客户号
           String bgRetUrl = "http://123.57.226.82/o/code/test";
          // String bgRetUrl = "http://mertest.chinapnr.com/muser/publicRequests";
           String RetUrl = "http://123.57.226.82/o/code/test";
           String UsrId = "jlhxy_201510161606";
           //String UsrName = "孙利阳";
           String UsrName = "孙利阳" ;
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
          // params.put("RetUrl", RetUrl);
          // params.put("UsrId",UsrId);
        //  params.put("UsrName",UsrName);
          // params.put("IdType",IdType);
         //  params.put("IdNo", IdNo);
         //  params.put("UsrMp", UsrMp);
         //  params.put("UsrEmail", UsrEmail);
         //  params.put("CharSet", CharSet);
           params.put("MerPriv", merPriv);

           // 组装加签字符串原文
           // 注意加签字符串的组装顺序参 请照接口文档
           StringBuffer buffer = new StringBuffer();
         /*  buffer.append(StringUtils.trimToEmpty(version)).append(StringUtils.trimToEmpty(cmdId))
               .append(StringUtils.trimToEmpty(merCustId)).append(StringUtils.trimToEmpty(bgRetUrl))
               .append(StringUtils.trimToEmpty(RetUrl)).append(StringUtils.trimToEmpty(UsrId))
               .append(StringUtils.trimToEmpty(UsrName)).append(StringUtils.trimToEmpty(IdType))
               .append(StringUtils.trimToEmpty(IdNo)).append(StringUtils.trimToEmpty(UsrMp))
               .append(StringUtils.trimToEmpty(UsrEmail)).append(StringUtils.trimToEmpty(bgRetUrl))
               .append(StringUtils.trimToEmpty(merPriv));*/
           buffer.append(StringUtils.trimToEmpty(version)).append(StringUtils.trimToEmpty(cmdId))
           .append(StringUtils.trimToEmpty(merCustId)).append(StringUtils.trimToEmpty(bgRetUrl))
           .append(StringUtils.trimToEmpty(merPriv));
           String plainStr = buffer.toString();
           System.out.println(plainStr);
           try {
			params.put("ChkValue", SignUtils.encryptByRSA(plainStr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	request.setAttribute("params", params);
    	response.setContentType("text/html; charset=gb2312");
    	try {
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	
    }

}
