<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body>
<form action="/message/enterMessageServlet" method="post">
	<h1>小小留言板</h1>
	用户名：<input type="text" name="name"><font color="red">${msg }</font><br>
	密码：<input type="password" name="password"><br>
	<input type="submit" value="登录">&nbsp;
	<a href="addUser.jsp">[注册]</a>
	 
</form>

</body>
</html>