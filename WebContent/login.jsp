<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SMS登录页面</title>
</head>
<body>${msg}
   ${msig}
    <form action="bs" method="get">
        学号：<input type="text" name="dlusername"/><br>
        密码：<input type="text" name="dlpassword"/><br>
        <input type="submit" value="登录">
    </form>
    <a href="./register.jsp">注册</a>
</body>
</html>
