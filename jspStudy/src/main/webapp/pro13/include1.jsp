<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1</title>
</head>
<body>
	안녕! 시작부분
	<jsp:include page="duke_image.jsp">
		<jsp:param value="듀크" name="name"/>
		<jsp:param value="duke.png" name="imgName"/>
	</jsp:include>
	<br/>
	끝부분
</body>
</html>