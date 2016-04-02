<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>hello spring mvc</title>
  </head>
  <body>
用户1id:${user1.id }<br>
用户1名：${user1.userName }<br>
用户1密码：${user1.password }
<br><br>
用户2id:${user2.id }<br>
用户2名：${user2.userName }<br>
用户2密码：${user2.password }
  </body>
</html>
