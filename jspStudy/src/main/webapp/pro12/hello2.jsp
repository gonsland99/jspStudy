<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "듀크";
	public String getName(){return name;}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 선언문</title>
</head>
<body>
	<h1><%=name %></h1>
</body>
</html>