<%@page import="message.entity.Message"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加留言</title>
</head>
<body>
<form action="/message/AddMessageServlet">
	<table align="center" border="1" width="500px">
		<tr>
			<th>用户名:</th>
			<td>${loginName}</td>
		</tr>
		
		<tr>
			<th>留言</th>
			<td><textarea rows="10" cols="30" name="texts"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="保存"/>&nbsp;
			<input type="reset" value="重置">
			</td>
		</tr>
		<tr>
			<td colspan="8" align="center"><a href="/message/ListMessageServlet">[查看所有留言]</a></td>
		</tr>
	</table>
	
</form>

</body>
</html>