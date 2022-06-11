<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="pro14.sec01.ex01.MemberBean"/>
<jsp:setProperty name="m" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력3</title>
</head>
<body>
	<table align="center">
		<tr align="center" bgcolor="99ccff">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		<tr align="center">
			<td><%=m.getId() %></td>
			<td><%=m.getPw() %></td>
			<td><%=m.getName() %></td>
			<td><%=m.getEmail() %></td>
		</tr>
		<tr align="center">
			<td>${m.id }</td>
			<td>${m.pw }</td>
			<td>${m.name }</td>
			<td>${m.email }</td>
		</tr>
	</table>
</body>
</html>