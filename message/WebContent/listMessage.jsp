<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看所有留言</title>
<style type="text/css">
	table td{
		/*text-align:center;*/
	}
	
	table{
		border-collapse:collapse;
	}
</style>
</head>
<body>
<center><h1>欢迎来到留言板</h1></center>
<center><h3>这里是所有人留言</h3></center>
<table align="center" border="1" width="500px">
	<c:forEach items="${ messages}" var="mes" varStatus="varSta">
	<tr>
		<th><font color="red">编号</font></th>
		<td>${varSta.count}</td>
	</tr>
	<tr>
		<th>用户：</th>
		<td>${mes.name}</td>
	</tr>
	<tr>
		<th>留言：</th>
		<td>${mes.texts}</td>
	</tr>
	<tr><td><br></td></tr>
	</c:forEach>
	<tr>
		<td colspan="8" align="center"><a href="addMessage.jsp">[我要写留言]</a></td>
	</tr>
</table>
</body>
</html>