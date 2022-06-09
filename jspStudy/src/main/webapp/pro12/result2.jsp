<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result2 page</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
	%>
	<%
		if(user_id==null || user_id.length()==0){
	%>
		아이디를 입력하세요<br/>
		<a href="login.html">로그인 하기</a>
	<%
		}else{
	%>
		<h1>환영합니다. <%=user_id %>님!!</h1>
	<%
		}
	%>
</body>
</html>