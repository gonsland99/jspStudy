<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	String address = (String)application.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두번째 페이지</title>
</head>
<body>
	이름: <%=name %> <br/>
	주소: <%=address %>
</body>
</html>