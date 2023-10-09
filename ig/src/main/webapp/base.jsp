<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>베이스</title>
</head>
<body>
	<c:forEach items="${list}" var="list">
		<tr>
			<th>BASE</th>
			<td>${list[0].BASE_DATA}</td>
		</tr>
		<tr>
			<th>ORACLE</th>
			<td>${list[0].ORCL_DATA}</td>
		</tr>
		<tr>
			<th>MYSQL</th>
			<td>${list[0].MYSQL_DATA}</td>
		</tr>
		<tr>
			<th>MARIA</th>
			<td>${list[0].MARIA_DATA}</td>
		</tr>
	</c:forEach>
</body>
</html>