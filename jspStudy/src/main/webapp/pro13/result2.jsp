<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login result</title>
</head>
<body>
	<%
		String id = request.getParameter("userID");
		if(id.length()==0){
			String msg = "아이디를 입력하지 않았습니다!!";
	%>
		<jsp:forward page="login2.jsp">
			<jsp:param value="<%=msg%>" name="msg"/>
		</jsp:forward>
	<%
		}
	%>
	<h1>환영합니다! <%=id %>님!</h1>
</body>
</html>