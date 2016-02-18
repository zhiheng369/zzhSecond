            ╭───────────────────────╮
    ────┤           汇付天下代码示例结构说明             ├────
            ╰───────────────────────╯ 
　                                                                  
　 　    代码版本：1.0
         开发语言：JAVA
         版    权：汇付天下有限公司
　       制 作 者：汇付天下有限公司信息技术中心

    ─────────────────────────────────

───────
 代码文件结构
───────
                          
├─src
│  └─com
│      └─huifu
│          ├─controller
│          │      LoansServlet.java  ------------------接收异步应答
│          │      
│          └─util
│              │  SignUtils.java  ------------------签名与验签
│              │  TransSubmit.java  -----------------调用汇付接口与接收同步应答
│              │  
│              └─httpClient
│                      HttpClientHandler.java  ------------------http请求工具类
│                      
└─WebContent
    ├─META-INF
    │      MANIFEST.MF
    │      
    └─WEB-INF
        │  web.xml
        │  
        └─lib
                chinapnr.jar
                commons-lang-2.6.jar
                commons-logging-1.1.3.jar
                httpclient-4.3.3.jar
                httpcore-4.3.2.jar
                
