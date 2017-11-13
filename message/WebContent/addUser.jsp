<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center><h3>欢迎注册留言板</h3></center>
<form action="/message/AddUserServlet" method="post">
<table align="center" border="1" width="300px">
<tr>
	<th>用户名</th>
	<td><input type="text" name="name"/><font color="red">${msg }</font></td>
</tr>
<tr>
	<th>密码</th>
	<td><input type="text" name="password"/></td>
</tr>
<tr>
	<th>电话</th>
	<td><input type="text" name="phone"/></td>
</tr>
<tr>
	<th>qq</th>
	<td><input type="text" name="qq"/></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="submit" value="注册"/>&nbsp;
	<input type="reset" value="重置">
	</td>
</tr>
</table>
</form>
</body>
</html>