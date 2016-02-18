<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>测试页面</title>
</head>

<body>
  <% Map<String,String> map =  (Map<String,String>)request.getAttribute("params");
   System.out.println(request.getAttribute("params"));
   System.out.println(map);
  %>
   <h4>处理中...</h4>
    <form action="http://mertest.chinapnr.com/muser/publicRequests" id="frm1" method="post">
        	  <%for(Map.Entry entry : map.entrySet()){%>
        	  <input type="hidden" name="<%=entry.getKey() %>" value="<%=entry.getValue() %>" />
        	  <%} %>
    </form>

    <script language="javascript">
     document.getElementById("frm1").submit();
    </script>
 
 
</body>
</html>